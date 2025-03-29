/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import com.example.dao.ModuleDAO;
import com.example.model.Module;
import com.example.model.Student;
import com.example.model.Teacher;
import com.sun.org.apache.xpath.internal.operations.Mod;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Udith
 */

@Path("/modules")
public class ModuleResource {

    private ModuleDAO moduleDAO = new ModuleDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Module> getAllModules(){
        return moduleDAO.getAllModules();
    }

    @GET
    @Path("/{moduleId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Module getModuleById(@PathParam("moduleId") int moduleId){
        return moduleDAO.getModuleById(moduleId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addModule(Module module){
        moduleDAO.addModule(module);
    }

    @PUT
    @Path("/{moduleId")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateModule(@PathParam("moduleId") int moduleId, Module updatedModule){
        Module existingModule = moduleDAO.getModuleById(moduleId);
        if(existingModule != null){
            updatedModule.setId(moduleId);
            moduleDAO.updateModule(updatedModule);
        }
    }

    @DELETE
    @Path("/{moduleId}")
    public void deleteModule(@PathParam("moduleId") int moduleId){
        moduleDAO.deleteModule(moduleId);
    }

    @GET
    @Path("/teacher/{teacherId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Module> getModulesByTeacher(@PathParam("teacherId") int teacherId) {
       List<Module> modulesByTeacher = new ArrayList<>();
       List<Module> allModules = moduleDAO.getAllModules();

       for(Module module:allModules){
           Teacher moduleTeacher = module.getTeacher();
           if(moduleTeacher.getId() == teacherId){
               modulesByTeacher.add(module);
           }
       }
        return modulesByTeacher;
    }

}
