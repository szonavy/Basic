package practice.basicexcercise._05_factorial;

import java.util.Scanner;

public class MainFact {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please give me a number: ");
        int n = sc.nextInt();
        int result = 1;
        System.out.println(n + "! = ");

        for(int i = n; i >= 1; i--){
            System.out.println(i);
            result *= i;
        }
        System.out.println("Result: " + result);
    }



}
