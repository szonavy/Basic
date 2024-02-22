package practice.basicexcercise._01_inout;

import java.util.Scanner;

public class inOut {
    public static void main(String[] args) {
        System.out.println("Please give 3 integer");
        Scanner nr1 = new Scanner(System.in);
        System.out.println(nr1.nextInt() + "\n" + nr1.nextInt() + "\n" + nr1.nextInt() + "\n");
    }
}
