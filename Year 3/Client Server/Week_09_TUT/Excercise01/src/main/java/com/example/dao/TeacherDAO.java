/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Udith
 */
public class TeacherDAO {

    private static List<Teacher> teachers = new ArrayList<>();

    static{
        teachers.add(new Teacher(1, "John"));
        teachers.add(new Teacher(2, "Samuel"));
    }

    public List<Teacher> getAllTeachers(){
        return teachers;
    }

    public Teacher getTeacherById(int id){
        for(Teacher teacher: teachers){
            if(id == teacher.getId()){
                return teacher;
            }
        }
        return null;
    }

    public void addTeacher(Teacher newTeacher){
        teachers.add(newTeacher);
    }

    public void updateTeacher(Teacher updatedTeacher){
        for(int i = 0; i < teachers.size(); i++){
            Teacher currentTeacher = teachers.get(i);
            if(currentTeacher.getId() == updatedTeacher.getId()){
                teachers.set(i, updatedTeacher);
                System.out.println("Teacher has been updated");
                break;
            }
        }
        System.out.println("No matching records");
    }

    public void deleteTeacher(int id){
        teachers.removeIf(teacher -> teacher.getId() == id);
    }
}
