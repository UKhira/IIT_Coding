import java.text.DecimalFormat;

public class Teacher extends Person{
    
    private double salary;
    private String subject;
    
    public Teacher(String name, int age, String gender, double salary, String subject){
        super(name, age, gender);
        this.salary = salary;
        this.subject = subject;
    }

    public String moneyFormatter(double money){
        DecimalFormat moneyFormat = new DecimalFormat("'LKR: '###,###.00");
        return(moneyFormat.format(money));
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public String getSalary(){
        return(moneyFormatter(salary));
    }

    @Override
    public String toString(){
        return(String.format("%s is a Teacher who teaches %s and has %s amount of salary", super.toString(), subject, getSalary()));
    }
}
