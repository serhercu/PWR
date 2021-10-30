package Laboratories.Lab12.Task1;


public class Developer extends Employee
{
    public String position;

    public Developer(String nameVal,String idVal,
                    Double salaryVal, String positionVal)
    {
        super(nameVal, idVal, salaryVal);
        position = positionVal;
    }

    public String toString()
    {
        return ("First Name: " + name + " Id: " + id + " Salary: " + salary + " Position: " + position);
    }


}