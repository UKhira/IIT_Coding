package Interface;

public class Runner {
    public static void main(String[] args) {
        personRunner();
    }

    public static void personRunner(){
        Person student = new Student();
        student.setName("Bob");
        student.eat();
        System.out.println(student.getClass());
    }
}
