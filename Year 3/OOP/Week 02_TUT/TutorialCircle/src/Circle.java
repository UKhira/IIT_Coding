public class Circle {
    private double radius;
    private String color;

    public Circle(){
        this.radius = 1;
        this.color = "Blue";
    }

    public Circle (double r){
        radius = r;
    }

    public Circle (double r, String co){
        radius = r;
        color = co;
    }

    public void setRadius(int r){
        radius = r;
    }
    public double getRadius(){
        return radius;
    }

    public double getArea(){
        return (Math.PI * getRadius()* getRadius());
    }

    public String getColor() {
        return color;
    }


}
