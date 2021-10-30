package Tutorials.Tut.Tut3.List8.Cars;

public class Car {
    private String name;
    private String brand;
    private int year;
    private boolean fuel;

    public Car(String name, String brand, int year){
        this.name = name;
        this.brand = brand;
        this.year = year;
    }

    public String getName(){
        return name;
    }

    public String getBrand(){
        return brand;
    }

    public int getYear(){
        return year;
    }

    public boolean getFuel(){
        return fuel;
    }

    public void refuel(){
        this.fuel = true;
    }
}

