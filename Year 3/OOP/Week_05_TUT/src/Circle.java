public class Circle extends GeometricObject{

    protected double radius;

    public Circle(){}

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(boolean filled, String color, double radius) {
        super(filled, color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return (2 * Math.PI * radius);
    }

    @Override
    public double getArea() {
        return (Math.PI * (Math.pow(radius,2)));
    }

    @Override
    public String getShape() {
        return "Circle";
    }

    @Override
    public String toString() {
        return String.format("{ Type : %s%n%sArea : %f%nPerimeter : %f }%n", getShape(), super.toString(), getArea(), getPerimeter());
    }
}
