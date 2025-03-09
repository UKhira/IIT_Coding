/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tutorial.week03.socket2;

//import necessary libraries


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleChatServer {
    public static void main(String[] args) {
        try {
            //Create a new instance of the Server Socket and pass port number
            ServerSocket serverSocket = new ServerSocket(12345);

            //print out a message to say Server is running 
            System.out.println("Server is Running");

            // Wait for a client to connect and accept the client request
            Socket clientSocket = serverSocket.accept();

            //print out a message to say client connected and get the IP ddress
            System.out.println("Client Connected: " + clientSocket.getInetAddress().getHostAddress());

            // Input stream to receive messages from the client
            InputStream in = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            // Output stream to send messages to the client
            OutputStream out = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(out,true);

            //Create a buffer array with type byte, the size must be 1024
            byte[] bufferArr = new byte[1024];

            // Read messages from the client and print them
            Scanner inp = new Scanner(System.in);
            String message;
            while((message = reader.readLine()) != null){
                System.out.println("Client: " + message);

                System.out.println("Enter message: ");
                String msg = inp.nextLine();
                writer.println(msg);
            }

            // Close the sockets
            clientSocket.close();
            serverSocket.close();

            //catch IO exception
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
