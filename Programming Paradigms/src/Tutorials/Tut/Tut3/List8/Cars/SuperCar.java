package Tutorials.Tut.Tut3.List8.Cars;

public class SuperCar extends Car{
    private int typeOfLicence;

    public SuperCar(String name, String brand, int year, int typeOfLicence) {
        super(name, brand, year);
        this.typeOfLicence = typeOfLicence;
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

    public int getTypeOfLicence(){
        return typeOfLicence;
    }

    public void refuel(){
        super.refuel();
    }
}
