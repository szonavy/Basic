package practice.basicexcercise._07_arrays_sum;

import java.util.Scanner;

public class MainArraysSum {
    public static void main(String[] args) {
        System.out.println("Give me a number between -1 and 7");
        Scanner sc = new Scanner(System.in);
        int requestedNumber = sc.nextInt();
        int count = 0;

        int[] numbers = new int[100];

        for(int i = 0; i < 100; i++){
            numbers[i] = i % 7;
        }

        for(int i = 0; i < numbers.length; i++){
           if(requestedNumber == numbers[i]){
               count++;
           }
        }
        System.out.println("The number appers " + count + " times in the stack.");
    }

}
