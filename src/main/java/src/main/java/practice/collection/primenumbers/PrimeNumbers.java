package practice.collection.primenumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int count = 0;
        List<Integer> prime = new ArrayList<>();

        int i = 2;
        while(i != number+1){
            if(i % 2 == 0){
                count++;
            }
            if(i % 3 == 0){
                count++;
            }
            if(i % 4 == 0){
                count++;
            }
            if(i % 5 == 0){
                count++;
            }
            if(i % 7 == 0){
                count++;
            }
            if(i % 9 == 0){
                count++;
            }
            if(i % 11 == 0){
                count++;
            }
            if(i % 13 == 0){
                count++;
            }
            if(i % 23 == 0){
                count++;
            }

            if(count > 1){
                count = 0;
            }else{
                prime.add(i);
            }
            i++;
        }
        System.out.println(prime);
    }
}
