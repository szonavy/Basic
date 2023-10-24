package practice.classes.employee;

public class Account {

    int id;
    String name;
    int balance;

    public Account(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(int id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    public void credit(int amount){
        balance += amount;
    }

    public void debit(int amount){
        if(amount > balance){
            System.out.println("Amount exceeded.");
        }else{
            balance -= amount;
        }
    }

    public void transferTo(Account anotherAccount, int amount){
        if(amount > balance){
            System.out.println("Amount exceeded.");
        }else{
            balance -= amount;
            anotherAccount.balance += amount;
        }
    }

}
