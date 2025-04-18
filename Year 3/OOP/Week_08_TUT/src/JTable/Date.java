package JTable;

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
        return this.day;
    }

    public int getMonth(){
        return this.month;
    }

    public int getYear(){
        return this.year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setMonth(int month){
        this.month = month;
    }

    public void setDay(int day){
        this.day = day;
    }

    public String getDate(){
        return String.format("%d/%d/%d",this.year, this.month, this.day);
    }

    @Override
    public String toString(){
        return ("Date [ day " + day + " month = " + month + " year = " + year + "]");
    }
}

