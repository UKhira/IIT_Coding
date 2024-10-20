public class Cylinder extends Circle {
    private double height;

    protected Cylinder(){
        height = 1.0;
    }

    protected Cylinder(double radius, double height){
        super(radius);
        this.height = height;
    }

    protected Cylinder(double radius, double height, String color){
        super(color, radius);
        this.height = height;
    }

    public double getHeight(){
        return height;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getVolume(){
        return (super.getArea() * height);
    }

    @Override
    public double getArea(){
        return ( (super.getArea() * 2) + (2 * Math.PI * radius * height));
    }

    @Override
    public String toString(){
        return (String.format("Cylinder with a %.2f and height of %.2f has an Area of %.2f and a volume of %.2f", super.getRadius(), getHeight(), getArea(), getVolume()));
    }
}
