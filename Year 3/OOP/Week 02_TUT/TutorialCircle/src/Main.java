import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();

        System.out.println(circle.setRadius(20))n;
        System.out.println(circle.getArea());

        Circle newCircle = new Circle(8);
        System.out.println(newCircle.getArea());

        Circle circleThree = new Circle(7, "Red");
        System.out.println(circleThree.getArea());
        System.out.println(circleThree.getColor());


    }
}