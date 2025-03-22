/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tutorial_week08_ex01;

/**
 *
 * @author admin
 */
public class Student {
    private String id;
    private String firstName;
    private String lastName;
    
    public Student(String id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }    
    
    public Student(){}
    
    public String getId(){
        return this.id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getfirstName(){
        return this.firstName;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    @Override
    public String toString(){
        return String.format("ID: %s First Name: %s Last Name: %s", this.id, this.firstName, this.lastName);
    }
}
