/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.serversocket.helloworld1;

/**
 *
 * @author Udith
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorldResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public HelloResponse getHello() {
        return new HelloResponse( "Hello World!");
    }


    public static class HelloResponse{

        private String message;

        public HelloResponse(String message){
            this.message = message;
        }

        public String getMessage(){
            return this.message;
        }

        public void setMessage(String message){
            this.message = message;
        }

    }

}


