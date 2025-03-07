import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
//            Create a server socket listening on port 12345
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is starting on port 12345...");

//            Accept Incoming client connections
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected " + clientSocket.getInetAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

//            Read data from client and echo it back
            String clientMessage;
            while((clientMessage = reader.readLine()) != null){
                System.out.println("Received from client " + clientMessage);
                writer.println("Server echoes " + clientMessage);
            }

//            Close resources
            reader.close();
            writer.close();
            clientSocket.close();
            serverSocket.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
