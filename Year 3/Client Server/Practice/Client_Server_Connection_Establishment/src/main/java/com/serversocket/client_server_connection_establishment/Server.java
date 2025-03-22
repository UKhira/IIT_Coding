/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.serversocket.client_server_connection_establishment;
import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;
/**
 *
 * @author Udith
 */
public class Server {
        public static void main(String[] args) {
            try{
                System.out.println("Waiting for client request");
                ServerSocket serversocket = new ServerSocket(9806);
                
//                Wait till client request
                Socket socket = serversocket.accept();
                System.out.println("Connection established");
            }
            catch(IOException e){
                e.printStackTrace();
            }
    }
}
