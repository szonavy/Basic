package practice.basicexcercise._06_array;

import java.util.Scanner;

public class MainArray {
    public static void main(String[] args) {
        System.out.println("Please give me the length of your array: ");

        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] array = new int[length];
        int result = 0;

        System.out.println("Please give me the element of your array: ");
        for(int i = 0; i < length; i++){
            array[i] = sc.nextInt();
            result += array[i];
        }
        System.out.println("The length of the array is: " + result);

    }
}
