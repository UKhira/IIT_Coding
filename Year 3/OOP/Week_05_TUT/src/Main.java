//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(true, "red", 7);
        System.out.println(circle);

        Square square = new Square(false, "Green",4);
        System.out.println(square);

        Rectangle rectangle = new Rectangle(true, "Orange", 14, 20);
        System.out.println(rectangle);
    }
}