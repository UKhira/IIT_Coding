public class Person {
    private String name;
    private String surName;
    private int age;

    public Person(String n){
        name = n;
    }

// Let’s make the Person class do something: create a constructor that takes a String and sets the name to be that String. Also, write a method called displayName(), which will print the name on the screen.
    public void displayName(){
        System.out.println(name);
    }
//  Write for the class Person other two methods that set the surname and the age:

    public void setSurname(String surName){
        this.surName = surName;
    }

    public void setAge(int age){
        this.age = age;
    }
    
// Implement also accessory methods to return the surname and the age.
    public String getSurName(){
        return surName;
    }

    public int getAge(){
       return age;
    }
}


