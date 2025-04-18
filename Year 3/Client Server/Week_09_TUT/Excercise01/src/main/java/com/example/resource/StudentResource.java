/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import com.example.dao.ModuleDAO;
import com.example.dao.StudentDAO;
import com.example.model.Module;
import com.example.model.Student;

import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.rmi.MarshalException;
import java.util.List;

/**
 *
 * @author Udith
 */

@Path("/students")
public class StudentResource {

    private StudentDAO studentDAO = new StudentDAO();
    private ModuleDAO moduleDAO = new ModuleDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudents(){
        return studentDAO.getAllStudents();
    }

    @GET
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudentById(@PathParam("studentId") int studentId){
        return studentDAO.getStudentById(studentId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addStudent(Student newStudent){
        studentDAO.addStudent(newStudent);
    }


    @PUT
    @Path("/{studentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateStudent(@PathParam("studentId") int studentId, Student updatedStudent){
        Student existingStudent = studentDAO.getStudentById(studentId);
        if(existingStudent != null){
            updatedStudent.setId(studentId);
            studentDAO.updateStudent(updatedStudent);
        }
    }

    @DELETE
    @Path("/studentId")
    public void deleteStudent(@PathParam("studentId") int studentId){
        studentDAO.deleteStudent(studentId);
    }

    @GET
    @Path("/{studentId}/modules")
    @Produces(MediaType.APPLICATION_JSON)
    public String getModulesForStudent(@PathParam("studentId") int studentId) {
        Student student = studentDAO.getStudentById(studentId);
        if (student != null) {
            int moduleId = 1;
            Module selectedModule = moduleDAO.getModuleById(moduleId);
            if (selectedModule != null) {
                String jsonString = "{\"module\": \"" + selectedModule.getName() + "\", \"teacher\": \"" + selectedModule.getTeacher().getName() + "\"}";
                return jsonString;
            }
        }
        return "{\"error\": \"Student or module not found\"}";
    }

}
