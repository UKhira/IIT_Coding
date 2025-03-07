import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try{
//            Create a socket to connect to the server
            Socket socket = new Socket("localhost", 12345);

//            Create input and output streams for communication with the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

//            Send a message to server
            writer.println("Hello, Server");

//            Receive and print response from server
            String serverResponse = reader.readLine();
            System.out.println("Server Says " + serverResponse);

//            Close resources
            reader.close();
            writer.close();
            socket.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
