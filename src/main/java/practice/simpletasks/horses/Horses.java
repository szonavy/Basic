package practice.simpletasks.horses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Horses {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        int N = in.nextInt();
        int min=100000;

        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            numbers.add(pi);
        }

        for(int i = 0; i < N-1; i++){
            int res = numbers.get(i) - numbers.get(i+1);
            if(res < 0){
                res *= -1;
            }
            if(res < min){
                min= res;
            }
        }
        System.out.println(min);
    }
}
