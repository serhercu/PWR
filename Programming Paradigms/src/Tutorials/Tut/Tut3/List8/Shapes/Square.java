package Tutorials.Tut.Tut3.List8.Shapes;

public class Square implements Shape{
    private double length, width;

    public Square(double length, double width){
        this.length = length;
        this.width = width;
    }

    public double area(){
        return length * width;
    }

    public double perimeter(){
        return length * 4;
    }
}
