package Sample.Class;

public class Car {
    String make;
    String model;
    int year;

    public Car(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void displayInfo(){
        System.out.println("Make: " + this.make);
        System.out.println("Model: " + this.model);
        System.out.println("Year: " + this.year);
    }
}
