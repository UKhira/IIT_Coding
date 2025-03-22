/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.serversocket.clientserverapp;
import java.net.ServerSocket;
//import java.lang.Exception;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
/**
 *
 * @author Udith
 */
public class TCPServer {

    public static void main(String[] args) throws Exception{
        String clientmsg;
        String capitalizedMsg;
        
        ServerSocket welcomeSocket = new ServerSocket(9806);
        
        System.out.println("Waiting for client");
        while(true){
            Socket connectionSocket = welcomeSocket.accept();
            System.out.println("Connection has established");
            
            System.out.println("Getting client data");
            
//            to read the string sent by client
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            
            DataOutputStream outputToClient = new DataOutputStream(connectionSocket.getOutputStream());
            
            clientmsg = inFromClient.readLine();
            capitalizedMsg = clientmsg.toUpperCase() + '\n';
            
//            Send the capitalized msg back to client
            outputToClient.writeBytes(capitalizedMsg);
        }
    }
}
