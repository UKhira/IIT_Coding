public class Main {
    
    public static void main(String[] args) {

        Person person = new Person("Senith", 21, "Male");
        System.out.println(person);


        Student student = new Student("Zein", 12, "Male", 2000.00, 3, 200422);
        System.out.println(student);

        Teacher teacher = new Teacher("jane", 34, "Female", 30000.00, "Mathematics");
        System.out.println(teacher);
    }
    
}
