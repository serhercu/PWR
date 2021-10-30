package Tutorials.Tut.Tut3.List8.Cars;

public class SportCar extends Car{
    private int cv;

    public SportCar(String name, String brand, int year, int cv){
        super(name, brand, year);
        this.cv = cv;
    }

    public String getName(){
        return super.getName();
    }

    public String getBrand(){
        return super.getBrand();
    }

    public int getYear(){
        return super.getYear();
    }

    public boolean getFuel(){
        return super.getFuel();
    }

    public int getCv(){
        return cv;
    }

    public void refuel(){
        super.refuel();
    }
}
