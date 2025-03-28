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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/hello")
public class HelloWorldResource {
    
    private static Map <Integer, String> users = new HashMap<>();
    
    static{
        users.put(1, "Sam");
        users.put(2, "Arthur");
        users.put(3, "Xiao");
    }
    
    @GET
    @Path("/user/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserById(@PathParam("userId") int userid) {
        return users.get(userid);
    }

    @GET
    @Path("/allUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<Integer, String> getAllUsers(){
        return users;
    }

}


