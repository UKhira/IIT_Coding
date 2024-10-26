import java.util.ArrayList;
import java.util.Scanner;

public class GeometricShapeCollection implements ShapeCollection{

    protected ArrayList<GeometricObject> shapeList;
    protected int maxObjCount;

    public GeometricShapeCollection(int maxObjCount) {
        this.shapeList = new ArrayList<GeometricObject>();
        this.maxObjCount = maxObjCount;
    }

    @Override
    public void addShape(GeometricObject shape) {
        if(shapeList.size() < maxObjCount){
            shapeList.add(shape);
        }
        else {
            System.out.println("List is Full");
        }
    }

    @Override
    public void printShape() {
        GeometricObject shapePlaceHolder;
        for (GeometricObject geometricObject : shapeList) {
            shapePlaceHolder = geometricObject;
            System.out.printf("{ Type : %s %nColor : %s %nPerimeter : %f %nArea : %f }", shapePlaceHolder.getShape(),shapePlaceHolder.getColor(), shapePlaceHolder.getPerimeter(), shapePlaceHolder.getArea());
        }
    }

    @Override
    public boolean runMenu() {
        boolean exit = false;
        System.out.println("To Add a New shape Press 1 \nTo Print the List of shape Press 2 \nTo Exit Press 3");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            // Add new shape
            case 1:
                System.out.println("Press 1 If you want to add a Circle \nPress 2 If you want to add a Rectangle \nPress 3 If you want to add a Square");

                int option = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter the color of your shape");
                String color = scanner.nextLine();

                System.out.println("Is it Filled (Y/N)");
                String fill = scanner.nextLine();
                boolean isFilled = false;

                if (fill.equalsIgnoreCase("Y")) {
                    isFilled = true;
                } else if (fill.equalsIgnoreCase("N")) {
                    isFilled = false;
                } else {
                    System.out.println("Invalid Input");
                }

                switch (option) {
                    // Add a Circle
                    case 1:
                        System.out.println("Insert the radius");
                        int radius = scanner.nextInt();
                        Circle circle = new Circle(isFilled, color, radius);
                        this.addShape(circle);
                        break;

                    case 2:
                        // Add a rectangle
                        System.out.println("Insert width");
                        int width = scanner.nextInt();
                        System.out.println("Insert length");
                        int length = scanner.nextInt();
                        Rectangle rectangle = new Rectangle(isFilled, color, width, length);
                        this.addShape(rectangle);
                        break;

                    case 3:
                        // Add a square
                        System.out.println("Insert length");
                        int sidelength = scanner.nextInt();
                        Square square = new Square(isFilled, color, sidelength);
                        this.addShape(square);
                        break;

                    default:
                        System.out.println("Invalid input");
                        break;
                }
                break;

            case 2:
                this.printShape();
                break;

            case 3:
                exit = true;
                break;
        }
        return exit;
    }
}
