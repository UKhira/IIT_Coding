import java.text.DecimalFormat;

public class Student extends Person{

    private double fee;
    private int grade;
    private int idNumber;

    public Student(String name, int age, String gender, double fee, int grade, int id){
        super(name, age, gender);
        this.fee = fee;
        this.grade = grade;
        this.idNumber = id;
    }

    public String moneyFormatter(double money){
        DecimalFormat moneyFormat = new DecimalFormat("'LKR: '###,###.00");
        return(moneyFormat.format(money));
    }

    public void setFee(double fee){
        this.fee = fee;
    }

    public void setGrade(int grade){
        this.grade = grade;
    }

    public void setIdNumber(int id){
        this.idNumber = id;
    }

    public String getFee(){
        return(moneyFormatter(fee));
    }

    public int getGrade(){
        return(grade);
    }

    public int getIdNumber(){
        return idNumber;
    }

    @Override
    public String toString(){
        return(String.format("%s is a student who has fee of %s in grade %d and ID is %d", super.toString(), getFee(), grade, idNumber));
    }
    
}
