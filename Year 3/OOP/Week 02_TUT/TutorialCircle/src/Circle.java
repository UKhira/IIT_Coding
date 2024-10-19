public class Circle {

// Two private instance variables: radius of type double and colour of type String (with a default value of 1  and “blue” respectively)
    private double radius;
    private String color;

// Two overloaded constructors: a default constructor with no argument, and another that takes an argument of type double for the radius

    public Circle(){
        this.radius = 1;
        this.color = "blue";
    }

    public Circle (double radius){
        this.radius = radius;
    }

    public Circle (String color, double radius){
        this.color = color;
        this.radius = radius;
    }


// Two public methods that return the radius and the area respectively, for this instance.
    public double getRadius(){
        return radius;
    }

    public double getArea(){
        return (Math.PI * radius * radius);
    }

    public String getColor(){
        return color;
    }

    public String toString(){
        return(String.format("Circle withe radius of %.2f and color of %s has an area of %.2f", radius, color, getArea()));
    }

}
