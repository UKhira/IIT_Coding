/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.serversocket.clientserverapp;
import java.io.*;
import java.net.*;
/**
 *
 * @author Udith
 */
public class TCPClient {
    public static void main(String[] args) throws Exception{
        String sentence;
        String modifiedSentence;
           
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        
        Socket clientSocket = new Socket("localhost",9806);
        
        System.out.println("Enter a String");
        
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        sentence = inFromUser.readLine();
        
        outToServer.writeBytes(sentence + '\n');
        
        modifiedSentence = inFromServer.readLine();
        
        System.out.println("From Server: " + modifiedSentence);
        
        clientSocket.close();
    }
}
