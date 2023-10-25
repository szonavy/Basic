package practice.classes.employee;

public class Main {

    public static void main(String[] args) {

        Employee T = new Employee(1,"Thomas","Scott",4000);
        Employee V = new Employee(2,"Valerie","Polo",6000);
        Employee A = new Employee(3,"Adam","Lamb",6000);
        Employee Z = new Employee(4,"Zac","Adams",3000);

        Account Thomas = new Account(1,"Thomas Scott",12000);
        Account Valerie = new Account(2,"Valerie Polo",18000);
        Account Adam = new Account(3,"Adam Lamb",5000);
        Account Zac = new Account(4,"Zac Adams",20000);

        System.out.println("\nEmployes: ");
        System.out.println(T.getName() + " salary: " + T.getAnnualSalary());
        System.out.println(V.getName() + " salary: " + V.getAnnualSalary());
        System.out.println(A.getName() + " salary: " + A.getAnnualSalary());
        System.out.println(Z.getName() + " salary: " + Z.getAnnualSalary() +"\n");

        T.raiseSalary(50);
        A.raiseSalary(10);
        System.out.println(T.getName() + " salary: " + T.getAnnualSalary());
        System.out.println(A.getName() + " salary: " + A.getAnnualSalary());

        System.out.println("\n Account:");
        System.out.println(Thomas.getId() + " " + Thomas.getName() + " " + Thomas.getBalance());
        System.out.println(Valerie.getId() + " " + Valerie.getName() + " " + Valerie.getBalance());
        System.out.println(Adam.getId() + " " + Adam.getName() + " " + Adam.getBalance());
        System.out.println(Zac.getId() + " " + Zac.getName() + " " + Zac.getBalance());

        Thomas.credit(100);
        System.out.println("\nThomas's new balance " + Thomas.getBalance());
        Thomas.transferTo(Valerie,50);
        System.out.println("Thomas's new balance after the transfer " + Thomas.getBalance());
        System.out.println("Valerie's new balance " + Valerie.getBalance());
        Valerie.debit(50);
        System.out.println("Valerie's new balance after the spending (50): " + Valerie.getBalance());
        Valerie.debit(10000);
        System.out.println("Valerie's new balance after the spending (10.000): " + Valerie.getBalance());

    }
}
