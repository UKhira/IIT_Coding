public class Rectangle extends  GeometricObject{

    protected double width;
    protected double length;

    public Rectangle(){}

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(boolean filled, String color, double width, double length) {
        super(filled, color);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public String getShape() {
        return "Rectangle";
    }

    @Override
    public String toString() {
        return String.format("{ Type : %s%n%sArea : %f%nPerimeter : %f }%n", getShape(), super.toString(), getArea(), getPerimeter());
    }
}
