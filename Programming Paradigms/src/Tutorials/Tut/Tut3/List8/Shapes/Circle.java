package Tutorials.Tut.Tut3.List8.Shapes;

public class Circle implements Shape{
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double area(){
        return radius * radius * 3.14;
    }

    public double perimeter(){
        return radius * 3.14 * 2;
    }
}
