//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Volume =  PI*r^2*h
        Cylinder cylinder = new Cylinder();
//        System.out.println("Cylinder: " + " radius: " + cylinder.getRadius() + " height: " + cylinder.getHeight() + " base-Area: " + cylinder.getArea() + " volume: " + cylinder.getVolume());

        System.out.println(cylinder);

        Cylinder cylinder2 = new Cylinder(7, 12);
//        System.out.println("Cylinder 2: " + " radius: " + cylinder2.getRadius() + " height: " + cylinder2.getHeight() + " base-Area: " + cylinder2.getArea() + " volume: " + cylinder2.getVolume());


        Cylinder cylinder3 = new Cylinder(14, 7, "Red");
//        System.out.println("Cylinder 3: " + " radius: " + cylinder3.getRadius() + " height: " + cylinder3.getHeight() + " base-Area: " + cylinder3.getArea() + " volume: " + cylinder3.getVolume() + " color: " + cylinder3.getColor() );
        System.out.println(cylinder);
        System.out.println(cylinder.getRadius()* cylinder.getRadius()*Math.PI*cylinder.getHeight());
        System.out.println(cylinder2);
        System.out.println(cylinder3);
    }
}