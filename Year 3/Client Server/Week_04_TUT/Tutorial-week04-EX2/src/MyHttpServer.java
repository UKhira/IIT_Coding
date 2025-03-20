import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;

public class MyHttpServer {
    public static void main(String[] args) {
        try{
            HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);
            server.createContext("/hello", new MyHttpServer().new MyHandler());
            server.start();
            System.out.println("Server is starting on Port 8080");
        }
        catch (IOException e){
            System.out.println("Error starting the Server: " + e.getMessage());
            e.printStackTrace();
        }
    }

    class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            RequestHandlerThread requestThread = new RequestHandlerThread(exchange);
            requestThread.start();
        }
    }

    class RequestHandlerThread extends Thread{
        private HttpExchange exchange;

        RequestHandlerThread(HttpExchange exchange){
            this.exchange = exchange;
        }

        public void printHeaders(Headers headers){
            headers.forEach((key, value) -> System.out.println(key + ": " + String.join(", ", value)));
        }

        @Override
        public void run(){
            try{
//                Get request Information
                String requestMethod = exchange.getRequestMethod();
                URI requestURI = exchange.getRequestURI();
                Headers requestHeaders = exchange.getRequestHeaders();

//              Display request information
                System.out.println("\n=== INCOMING REQUEST ===");
                System.out.println("Method: " + requestMethod);
                System.out.println("URI: " + requestURI);
                System.out.println("Headers: ");
                printHeaders(requestHeaders);

//                Prepare response with request Information
                StringBuilder responseContent = new StringBuilder();
                responseContent.append("Request Details: \n");
                responseContent.append("Method: ").append(requestMethod).append("\n");
                responseContent.append("URI: ").append(requestURI).append("\n");
                responseContent.append("Headers: \n");
                requestHeaders.forEach((key, value) -> responseContent.append(key).append(": ").append(value).append("\n"));
                responseContent.append("Handled by Thread: ").append(Thread.currentThread().getName());

                String response = responseContent.toString();

//                Get response headers
                Headers responseHeaders = exchange.getResponseHeaders();

//                Send response
                exchange.sendResponseHeaders(200, response.getBytes().length);

//                Display response information
                System.out.println("\n==== OUTGOING RESPONSE ===");
                System.out.println("Status: 200 OK");
                System.out.println("Headers: ");
                printHeaders(responseHeaders);
                System.out.println("Body Length: " + response.getBytes().length + " bytes");

//                Send response body
                try (OutputStream os = exchange.getResponseBody()){
                    os.write(response.getBytes());
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
            finally {
                exchange.close();
            }
        }
    }
}
