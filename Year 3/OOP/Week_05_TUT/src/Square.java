public class Square extends GeometricObject{

    protected double side;

    public Square(){}

    public Square(double side) {
        this.side = side;
    }

    public Square(boolean filled, String color, double side) {
        super(filled, color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getPerimeter(){
        return 4 * side;
    }

    @Override
    public double getArea() {
        return (Math.pow(side,2));
    }

    @Override
    public String getShape() {
        return "Square";
    }

    @Override
    public String toString() {
        return String.format("Type : %s%n%sArea : %f%nPerimeter : %f%n", getShape(), super.toString(), getArea(), getPerimeter());
    }
}
