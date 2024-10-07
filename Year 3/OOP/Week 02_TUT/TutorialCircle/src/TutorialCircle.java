public class TutorialCircle {
    public static void main(String[] args) {
        
        Circle circleOne = new Circle();
        System.out.println(circleOne.getRadius());
        System.out.println(circleOne.getArea());
        System.out.println(circleOne);

        Circle circleTwo = new Circle(7);
        System.out.println(circleTwo.getRadius());
        System.out.println(circleTwo.getArea());     
        
        Circle circleThree = new Circle("purple", 26);
        System.out.println(circleThree.getRadius());
        System.out.println(circleThree.getColor());
        System.out.println(circleThree.getArea());
    }
}