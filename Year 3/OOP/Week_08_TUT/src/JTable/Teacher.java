package JTable;

public class Teacher extends Person{
    private double salary;

    public Teacher(double salary) {
        this.salary = salary;
    }

    public Teacher(String name, Date dob, double salary) {
        super(name, dob);
        this.salary = salary;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "salary=" + this.salary +
                ", name='" + super.name + '\'' +
                ", dob='" + super.dob + '\'' +
                '}';
    }
}
