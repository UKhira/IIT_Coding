/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.practicalexamfinal2024;


/**<QUESTION: Import necessary libraries (3 marks)*/
//PLACE YOUR CODES HERE
import java.util.logging.*;
import java.util.*;
import java.io.*;
import java.net.*;


public class MultiThreadedChatServer {
    /**<QUESTION: set up a logger for the MultiThreadedChatServer class (1 marks)
    */;
    private static final Logger logger = Logger.getLogger(MultiThreadedChatServer.class.getName());
    
    /**<QUESTION:
    - Create a List to keep track of connected clients (2 marks).
        - Please name the list as "clients"
        - The List inherits from ClientHandler class. So the type should be ClientHandler
    */
    static List <ClientHandler> clients = new ArrayList<>();
    
    public static void main(String[] args) {
        try {
            FileHandler fileHandler = new FileHandler("server_log.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

            /**<QUESTION:
            - Create a ServerSocket to listen for incoming client connections(2 marks) 
                - You may use a port number 12345 
            */
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is running and waiting for clients...");

            while (true) {
                /**<QUESTION:
                - Accept a new client connection (2 marks)*/
                 Socket clientSocket = serverSocket.accept();
                /**<QUESTION
                - use logger in info level to create the following messages (2 marks):
                    - "New client connected get 
                    - the IP address of the client
                */           
                logger.info("New Client connected" + clientSocket.getInetAddress());

                /**<QUESTION: Create a new instance of ClientHandler and 
                    pass clientSocket as its parameter(1.5 marks)*/
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                
                /**<QUESTION: add the clientHandler to the clients list(1 mark) */
                clients.add(clientHandler);
                
                /**<QUESTION: Create a new thread and call it as clientThread and 
                    pass clientHandler as its parameter (2 marks)*/
                Thread clientThread = new Thread(clientHandler);
                
                /**<QUESTION: Start the thread (1 mark)
                */           
                clientThread.start();
                
                
                
            }
        } catch (Exception e) {
            System.out.println("Error in the server: " + e.getMessage());
        }
    }

    // Broadcast a message to all connected clients (excluding the sender)
    static void broadcastMessage(String message, ClientHandler sender) {
        
        /**<QUESTION:
        - Create a for loop to iterate over the items inside clients list (2 marks)
            - check if the lient is not sender (1 mark)
                - invoke sendMessage method using ClientHandler object and pass message variable as its argument (1 mark)
        */
        //PLACE YOUR CODES HERE
        for(ClientHandler client: clients){
            if(client != sender){
                client.sendMessage(message);
            }
        }
        
        
        
    }
}

class ClientHandler implements Runnable {
    /**<QUESTION: Create a logger for the ClientHandler class (1 marks)*/
    private static final Logger logger = Logger.getLogger(ClientHandler.class.getName());
    
    /**<QUESTION: Please create variables as follows: */
        /**<1- clientSocket that should be an instance of Socket (1 mark) */
        Socket clientSocket = new Socket();
        
        /**< 2- reader that should be an instance of BufferedReader (1 mark) */
        BufferedReader reader;
        
        /**<3- writerthat should be an instance of PrintWriter (1 mark) */
        PrintWriter writer;
  
    /**<QUESTIONS:
    - Create a constructor of ClientHandler class with clientSocket as its argument(2 marks)
    - Then, inside the constructor, do the following steps:
        - Define a try-catch block (1 mark)
        - Inside the try, please do the followings: 
            - set up a new BufferedReader and wrap it with InputStreamReader 
            and invoke getInputStream() using clientSocket(2.5 marks)
            - set up a new PrintWriter and invoke getOutputStream using clientSocket and set it to true (2 marks)
        - catch input/output exception (1 mark)
            - use logger in severe mod to create a message like "Error setting up client handler: " (2 marks) 
    */
    //PLACE YOUR CODES HERE
          
    ClientHandler(Socket clientSocket){
        try{
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            writer = new PrintWriter(clientSocket.getOutputStream());
        }
        catch(IOException e){
            logger.severe("Error setting up client handler: ");
        }
    }
    
    
    
    

    @Override
    public void run() {
        try {
            // Read the username from the client
            String userName = reader.readLine();
            /**<QUESTION:
            - Create an info logger to have the following Information (2 marks)
                - username 
                - " has joined the chat from " as a message
                - the IP address of the client 
            */
            logger.info(userName + " has joined the chat from " + clientSocket.getInetAddress());
            
            // Broadcast the join message to all clients
            MultiThreadedChatServer.broadcastMessage(userName + " has joined the chat.", this);

            String clientMessage;
            // Read and broadcast messages from the client
            
            while ((clientMessage = reader.readLine()) != null) {
                /**<QUESTION:
                - Create an info logger to create the following information (2 marks)
                    - username
                    - the IP address of the client 
                    - clientMessage parameter
                */
                logger.info(userName + clientSocket.getInetAddress().toString() + clientMessage);
                MultiThreadedChatServer.broadcastMessage(userName + ": " + clientMessage, this);
            }
            
         /**<QUESTION:
            - Catch input/output exception (1 mark)
            - Create a warning logger by using ther following information (2 marks)
                - "A client has left the chat from "
                - IP address of the client 
        */
        } catch (IOException e) {
            logger.warning("A client has left the chat from " + clientSocket.getInetAddress().toString());
        } finally {
            try {
            /**<QUESTION: Close resources when the client leaves (3 marks)*/
                clientSocket.close();
                reader.close();
                writer.close();
                MultiThreadedChatServer.clients.remove(this);
          
            } catch (Exception e) {
                /**<QUESTION: 
                    - use logger in severe level to include the following information (2 marks)
                        - "Error closing client resources: "
                */
                logger.severe("Error closing client resources: ");
            }
        }
    }

    // Send a message to the client
    void sendMessage(String message) {
        writer.println(message);
    }
}
