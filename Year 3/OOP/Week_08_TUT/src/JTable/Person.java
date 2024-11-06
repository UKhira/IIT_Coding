package JTable;

public class Person {
    protected String name;
    protected Date dob;

    public Person(){}

    public Person(String name, Date dob){
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + this.name + '\'' +
                ", dob='" + this.dob + '\'' +
                '}';
    }
}
