package Laboratories.Lab12.Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args){

        List<? extends Employee> list2 = new ArrayList<Developer>(); // ok
        ///List<? extends Employee> list3 = new ArrayList<Person>(); // NO

        Developer develop = new Developer("Pepe", "1234", 123.0, "boss");
        Employee employ = new Employee("James", "3213", 125.0);
        Person pers = new Person("David", "1245");



        Developer[] myDevelopers = {develop};
        Person[] myPersons = myDevelopers;

        myPersons[0] = new Employee();

    }
}
