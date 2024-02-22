package practice.classes.circle;

public class Main {

    public static void main(String[] args) {
        Circle redCircle = new Circle(15.0,"red");
        Circle blueCircle = new Circle(16.7,"blue");
        Circle greenCircle = new Circle(1.5,"green");

        System.out.println("red radius: " + redCircle.getRadius() + " red area: " + redCircle.area());
        System.out.println("blue radius: " + blueCircle.getRadius() + " blue area: " + blueCircle.area());
        System.out.println("green radius: " + greenCircle.getRadius() + " green area: " + greenCircle.area());
        greenCircle.increaseRadius(2);
        System.out.println("green radius: " + greenCircle.getRadius() + " green area: " + greenCircle.area());
    }
}
