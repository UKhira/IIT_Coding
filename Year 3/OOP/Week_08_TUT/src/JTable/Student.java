package JTable;

public class Student extends Person{
    private int id;
    private String course;

    public Student(int id, String course) {
        this.id = id;
        this.course = course;
    }

    public Student(String name, Date dob, int id, String course) {
        super(name, dob);
        this.id = id;
        this.course = course;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + this.id +
                ", course='" + this.course + '\'' +
                ", name='" + super.name + '\'' +
                ", dob='" + super.dob + '\'' +
                '}';
    }
}
