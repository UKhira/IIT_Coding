package Interface;

public class Student implements Person{
    private String name;

    public Student(){}

    public Student(String name){
        this.name = name;
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public void eat(){
        System.out.println(this.name + " is eating");
    }

}
