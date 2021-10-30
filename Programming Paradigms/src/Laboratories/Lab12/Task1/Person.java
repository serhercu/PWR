package Laboratories.Lab12.Task1;

public class Person
{
    public String name;
    public String id;

    public Person()
    {
        name = "";
        id = "";
    }

    public Person(String nameVal, String idVal)
    {
        name = nameVal;
        id = idVal;
    }

    public String toString()
    {
        return ("First Name: " + name + " Id: " + id);
    }


}

