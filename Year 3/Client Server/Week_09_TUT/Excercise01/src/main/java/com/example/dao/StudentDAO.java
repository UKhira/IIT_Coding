/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Udith
 */
public class StudentDAO {

    private static List <Student> students = new ArrayList<>();

    static{
        students.add(new Student(1, "Udith"));
        students.add(new Student(2, "Kavishka"));
    }

    public List<Student> getAllStudents(){
        return students;
    }

    public Student getStudentById(int id){
        for(Student student : students){
            if(student.getId() == id){
                return student;
            }
        }
        return null;
    }

    public void addStudent(Student newStudent){
        int newUserId = getNextUserId();
        newStudent.setId(newUserId);
        students.add(newStudent);
    }

    public void updateStudent(Student updatesStudent){
        for(int i = 0; i < students.size(); i++){
            Student currentStudent = students.get(i);
            if(currentStudent.getId() == updatesStudent.getId()){
                students.set(i, updatesStudent);
                System.out.println("Student updated" + updatesStudent.toString());
                break;
            }
        }
        System.out.println("No Matching records");
    }

    public void deleteStudent(int id){
        students.removeIf(student -> (student.getId() == id));
    }

    public int getNextUserId() {
        int maxUserId = Integer.MIN_VALUE;
        for (Student student : students) {
            int userId = student.getId();
            if (userId > maxUserId) {
                maxUserId = userId;
            }
        }
        return maxUserId + 1;
    }


}

