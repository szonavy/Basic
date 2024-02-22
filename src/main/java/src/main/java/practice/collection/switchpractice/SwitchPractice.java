package practice.collection.switchpractice;

import java.util.Scanner;

public class SwitchPractice {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int firstNumber = sc.nextInt();
        String operator = sc.next();
        int secondNumber = sc.nextInt();

        switch(operator){
            case "+":
                System.out.println(firstNumber + secondNumber);
                break;
            case "-":
                System.out.println(firstNumber - secondNumber);
                break;
            case "*":
                System.out.println(firstNumber * secondNumber);
                break;
            case "/":
                System.out.println(firstNumber + secondNumber);
                break;
            default:
                System.out.println("Operation cannot be interpreted");
        }

    }
}
