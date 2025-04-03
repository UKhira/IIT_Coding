// Tutorial_Week09_DAO/src/main/java/com/example/resource/StudentResource.java
package com.example.resource;

import com.example.exception.ModuleNotFoundException;
import com.example.exception.StudentNotFoundException;
import com.example.model.Module;
import com.example.model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/students")
public class StudentResource {
    private static List<Student> students = new ArrayList<>();
    private static int nextId = 3;

    private static final Logger logger = Logger.getLogger(StudentResource.class.getName());

    static {
        students.add(new Student(1, "John Doe"));
        students.add(new Student(2, "Jane Doe"));
    }

    public static List<Student> getAllStudentsStatic() {
        return students;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudents() {
        logger.info("Get request for all Students");
        return students;
    }

    @GET
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudentById(@PathParam("studentId") int studentId) {
        logger.info("GET request for student with ID:" + studentId);
        return students.stream()
                .filter(student -> student.getId() == studentId)
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + studentId + " not found"));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addStudent(Student student) {
        student.setId(nextId++);
        students.add(student);
        logger.info("Added new student with ID" + student.getId());
    }

    @PUT
    @Path("/{studentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateStudent(@PathParam("studentId") int studentId, Student updatedStudent){
        logger.info("PUT request to update student with ID" + studentId);
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId() == studentId) {
                updatedStudent.setId(studentId);
                students.set(i, updatedStudent);
                logger.info( "Updated student with ID: " + studentId);
                return;
            }
        }
        throw new StudentNotFoundException("Student with ID " + studentId + "not found for update");
    }

    @DELETE
    @Path("/{studentId}")
    public void deleteStudent(@PathParam("studentId") int studentId) {
        logger.info("DELETE request for student with ID" + studentId);
        boolean removed = students.removeIf(student -> student.getId() == studentId);
        if(!removed){
            throw new StudentNotFoundException("Student with ID " + studentId + "not found for deletion");
        }
        else{
            logger.info("Deleted student with ID " + studentId);
        }
    }

    @GET
    @Path("/{studentId}/modules")
    @Produces(MediaType.APPLICATION_JSON)
    public String getModulesForStudent(@PathParam("studentId") int studentId) {
        logger.info( "GET request for modules for student with ID: " + studentId);
        Student student = getStudentById(studentId);
        int moduleId = 1; // Assuming the student selected module with ID 1
        Module selectedModule = ModuleResource.getAllModulesStatic().stream().filter(m -> m.getId() == moduleId).findFirst().orElseThrow(() -> new ModuleNotFoundException("Module with ID " + moduleId + "not found"));
        if (selectedModule != null) {
            logger.info("Retrieved module " + selectedModule.getName() + "for student ID " + studentId);
            return "{\"module\": \"" + selectedModule.getName()
                    + "\", \"teacher\": \"" + selectedModule.getTeacher().getName() + "\"}";
        }
        throw new ModuleNotFoundException("Module ID: " + moduleId + "Not found");
    }
}