package com.jaxrx.tutorial_week08_ex01.resources;

import com.jaxrx.tutorial_week08_ex01.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


@Path("/students")
public class StudentResource {
    private static final ConcurrentHashMap<String, Student> studentStore = new ConcurrentHashMap<>();

    static {
        addInitialStudents();
    }

    private static void addInitialStudents() {
        Student student1 = new Student(UUID.randomUUID().toString(), "Alice",
                "Smith");
        Student student2 = new Student(UUID.randomUUID().toString(), "Bob",
                "Johnson");
        Student student3 = new Student(UUID.randomUUID().toString(), "Charlie",
                "Brown");
        studentStore.put(student1.getId(), student1);
        studentStore.put(student2.getId(), student2);
        studentStore.put(student3.getId(), student3);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudents(){
        return new ArrayList<>(studentStore.values());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getStudentById(@PathParam("id") String id){
        if (studentStore.containsKey(id)){
            Student student = studentStore.get(id);
            return Response.ok(student).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createStudent(Student student){
        if(student.getFirstName() == null || student.getLastName() == null){
            return Response.status(Response.Status.BAD_REQUEST).entity("First name and last name are required.").build();
        }
        student.setId(UUID.randomUUID().toString());
        studentStore.put(student.getId(), student);
        return Response.status(Response.Status.CREATED).entity(student).build();
    }


    @Path(("/{id}"))
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStudent(@PathParam("id") String id, Student updatedStudent){
        if(!studentStore.containsKey(id)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Student existingStudent = studentStore.get(id);
        if (updatedStudent.getFirstName() != null) {
            existingStudent.setFirstName(updatedStudent.getFirstName());
        }
        if (updatedStudent.getLastName() != null) {
            existingStudent.setLastName(updatedStudent.getLastName());
        }

        studentStore.put(id, existingStudent);
        return Response.ok(existingStudent).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteStudent(@PathParam("id") String id) {
        Student removedStudent = studentStore.remove(id);
        if (removedStudent != null) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Student not found.").build();
        }
    }
}
