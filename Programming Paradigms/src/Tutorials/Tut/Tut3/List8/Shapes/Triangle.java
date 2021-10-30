package Tutorials.Tut.Tut3.List8.Shapes;

public class Triangle implements Shape{
    private double side1, side2, side3;

    public Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double area(){
        double s = perimeter();
        return Math.sqrt((s-side1)*(s-side2)*(s-side3));
    }

    public double perimeter(){
        return side1 + side2 + side3;
    }
}
