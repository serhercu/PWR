package Tutorials.Tut.Tut3.List8.Shapes;

public class Rectangle implements Shape {
    double base, height;

    public Rectangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    public double area(){
        return base * height;
    }

    public double perimeter(){
        return (base * 2) + (height * 2);
    }
}
