import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{

        String ip = "localhost";
        int port = 9999;  // 0 to 65545 range (0-1023 are reserved port numbers, so pick above 1023)
//        Socket of Client
        Socket socket = new Socket(ip, port);
//        Socket has 2 parameters (IP Address of server, Port Number)

//        Sending a request to server
        String str = "Udith Kavishka";

//        Convert data into a stream format
        OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
//        Parameter - OutputStreamWriter(Where you need to send from Data)

        PrintWriter out = new PrintWriter(os);
        os.write(str);

        os.flush();
    }
}
