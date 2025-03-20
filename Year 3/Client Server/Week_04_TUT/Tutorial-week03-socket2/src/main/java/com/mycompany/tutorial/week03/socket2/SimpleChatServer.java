/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.tutorial.week03.socket2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SimpleChatServer {

    private static final Logger logger = Logger.getLogger(Class.class.getName());

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            logger.info("Server is running and waiting for a client to connect...");

            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            logger.info("Client connected: " + clientSocket.getInetAddress());

            // Input stream to receive messages from the client
            InputStream inputStream = clientSocket.getInputStream();
            // Output stream to send messages to the client
            OutputStream outputStream = clientSocket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;

            // Read messages from the client and print them
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Client: " + message);
                logger.info("Received from Client: " + message);

                // Send a response back to the client
                String responseMessage = "Server received your message: " + message;
                outputStream.write(responseMessage.getBytes());
            }

            // Close the sockets
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "IOException occurred", e);
        }
    }

    static{
        try{
            FileHandler fileHandler = new FileHandler("logs.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        }
        catch(IOException e){
            logger.log(Level.SEVERE, "Failed to set up file handler for Logger", e);
        }
    }
}
