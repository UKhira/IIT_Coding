/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.serversocket.chatroom;
import java.util.HashSet;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.ServerSocket;
/**
 *
 * @author Udith
 */
public class ChatServer {
    private static final int PORT = 9801;
    private static HashSet<String> names = new HashSet<>();
    private static HashSet<PrintWriter> writers = new HashSet<>();
    
    public static void main(String[] args) throws Exception{
        System.out.println("Chat Server is running");
        
        ServerSocket listner = new ServerSocket(PORT);
        
        try{
            while(true){
                Socket socket = listner.accept();
                Thread handlerThread = new Thread(new Handler(socket));
                handlerThread.start();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            listner.close();
        }
    }
    
    private static class Handler implements Runnable{
        private String name;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        
        public Handler(Socket socket){
            this.socket = socket;
        }
        
        @Override
        public void run(){
            try{
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                
                while(true){
                    out.println("SUBMITNAME");
                    name = in.readLine();
                    
                    if(name == null)
                        return;
                    
                    if(!names.contains(name)){
                        names.add(name);
                        break;
                    }
                }
                out.println("NAMEACCEPTED");
                writers.add(out);
                
                while(true){
                    String input = in.readLine();
                    if(input == null)
                        return;
                    for(PrintWriter writer: writers){
                        writer.println("MESSAGE" + name + " " + input);
                    }
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
            finally{
                if(names != null)
                    names.remove(name);
                if( out != null)
                    writers.remove(out);
                try{
                    socket.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
