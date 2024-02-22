package practice.basicexcercise._02_if;

import java.util.Scanner;

public class IfMain {
    public static void main(String[] args) {

        System.out.println("Please give me a number: ");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(n % 2 != 0 || n % 2 == 0 && n >= 6 && n < 20){
            System.out.println("Weird");
        }else if(n % 2 == 0 && n >= 2 && n <= 5 || n > 20){
            System.out.println("Not Weird");
        }
    }
}
