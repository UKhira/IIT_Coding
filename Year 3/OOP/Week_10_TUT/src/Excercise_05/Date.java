package Excercise_05;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setDay(int day){
        this.day = day;
    }

    public void addDays(int days){this.day += days; }

    public String toString(){
        return ("Date [ day " + day + " month = " + month + " year = " + year + "]");
    }

    public String dateString(){
        return (day + "/" + month +  "/" + year);
    }

    public void printDate() {
        System.out.println("The date is " + this.year + "-" + this.month + "-" + this.day);
    }
}
