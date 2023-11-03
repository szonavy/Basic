package practice.simpletasks.anagrams;

import java.util.HashMap;
import java.util.Map;

public class Anagrams {


    public static void main(String[] args) {

        String a = "hello".toLowerCase();
        String b = "Hello".toLowerCase();
        Map<Character,Integer> aStrings = new HashMap<>();
        Map<Character,Integer> bStrings = new HashMap<>();



        for(int i = 0; i < a.length(); i++){
            if(aStrings.isEmpty() || !aStrings.containsKey(a.charAt(i))){
                aStrings.put(a.charAt(i),1);
            }else{
                aStrings.put(a.charAt(i),aStrings.get(a.charAt(i))+1);
            }
        }
        for(int i = 0; i < b.length(); i++){
            if(bStrings.isEmpty() || !bStrings.containsKey(b.charAt(i))){
                bStrings.put(b.charAt(i),1);
            }else{
                bStrings.put(b.charAt(i),bStrings.get(b.charAt(i))+1);
            }
        }
        System.out.println(aStrings);
        System.out.println(bStrings);

        if(aStrings.equals(bStrings)){
            System.out.println("Anagrams");
        }else{
            System.out.println("Not anagrams");
        }

    }
}
