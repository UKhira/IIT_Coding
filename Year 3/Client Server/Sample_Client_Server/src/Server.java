import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception{

        System.out.println("Server is starting");
        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("Server  is waiting for client request");

//        Whenever a client request comes, it will accept the request and need to create a socket
        Socket s = serverSocket.accept();
        System.out.println("Client connected");

//        fetch the data
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//        String str = br.readLine();
//
//        System.out.println("Client Data: " + str);
    }
}
