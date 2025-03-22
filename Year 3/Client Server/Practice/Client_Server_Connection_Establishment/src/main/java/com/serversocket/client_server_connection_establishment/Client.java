/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.serversocket.client_server_connection_establishment;
import java.net.Socket;
import java.io.IOException;
/**
 *
 * @author Udith
 */
public class Client {
    public static void main(String[] args) {
      
        try{
            Socket socket = new Socket("localhost",9806);
            System.out.println("Client has started");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
