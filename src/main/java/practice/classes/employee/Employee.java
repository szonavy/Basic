package practice.classes.employee;

public class Employee {

    int id;
    String firstName;
    String lastName;
    int salary;

    public Employee(int id, String firstName, String lastName, int salary){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastName = lastName; this.salary = salary;
    }

    public String getName(){
        return firstName + " " + this.lastName;
    }

    public int getAnnualSalary(){
        return salary * 12;
    }

    public void raiseSalary(int percent){
        salary += (salary * (percent / 100.));
    }
}
