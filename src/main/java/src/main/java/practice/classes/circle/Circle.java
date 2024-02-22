package practice.classes.circle;

public class Circle {
    double radius;
    String color;
    double pi = 3.14;

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void increaseRadius(int value) {
        this.radius = radius * value;
    }

    public double area(){
        return pi * (radius * radius);
    }

}
