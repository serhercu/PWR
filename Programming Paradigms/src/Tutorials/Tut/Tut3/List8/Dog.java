package Tutorials.Tut.Tut3.List8;

public class Dog {
    private String name; //identity
    private int age; //state
    private String race; //state
    private boolean hunger; //state

    public Dog(String name, int age, String race, boolean hunger){
        this.name = name;
        this.age = age;
        this.race = race;
        this.hunger = hunger;
    }

    public void Eat(){ //behaviour
        this.hunger = false;
    }

}
