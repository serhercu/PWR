package Laboratories.Lab12.Task1;


public class Employee extends Person
{
    public Double salary;

    public Employee() {
    }

    public Employee(String nameVal, String idVal,
                    Double salaryVal)
    {
        super(nameVal, idVal);
        salary = salaryVal;
    }

    public String toString()
    {
        return ("First Name: " + name + " Id: " + id + " Salary: " + salary);
    }


}

