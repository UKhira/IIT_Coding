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
import java.util.*;

@Path("/hello")
public class HelloWorldResource {
    
    private static List <User> users = new ArrayList<>();
    
    static{
        users.add(new User(1, "Sam", "sam@gmail.com"));
        users.add(new User(1, "Arthur", "art@gmail.com"));
        users.add(new User(1, "Xiao", "xiao@yahoo.com"));
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers(){
        return users;
    }


}


