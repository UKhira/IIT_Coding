/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Module;
import com.example.model.Teacher;
import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Udith
 */
public class ModuleDAO {

    private static List<Module> modules = new ArrayList<>();

    static{
        TeacherDAO teacherDAO = new TeacherDAO();
        List<Teacher> teachers = teacherDAO.getAllTeachers();

        modules.add(new Module(1, "Math", teachers.get(0)));
        modules.add(new Module(2, "Science", teachers.get(1)));
    }

    public List<Module> getAllModules(){
        return modules;
    }

    public Module getModuleById(int id){
        for(Module module: modules){
            if(module.getId() == id){
                return module;
            }
        }
        return null;
    }

    public void addModule(Module newModule){
        modules.add(newModule);
    }

    public void updateModule(Module updatedModule){
        for(int i = 0; i < modules.size(); i++){
            Module currentModule = modules.get(i);
            if(currentModule.getId() == updatedModule.getId()){
                modules.set(i, updatedModule);
                break;
            }
        }
        System.out.println("No Matching records");
    }

    public void deleteModule(int id){
        modules.removeIf(module -> module.getId() == id);
    }
}
