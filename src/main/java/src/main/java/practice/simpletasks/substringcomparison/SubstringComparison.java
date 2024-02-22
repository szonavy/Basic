package practice.simpletasks.substringcomparison;

public class SubstringComparison {

    public static void main(String[] args) {
        String s = "welcometojava";
        int k = 3;
        String smallest = "z";
        String largest = "";

        for(int i = 0; i < s.length()-k+1; i++ ){
            String actual = s.substring(i,i+k);

            if(smallest.compareTo(actual) > 0){
                smallest = actual;
            }
            if(largest.compareTo(actual) < 0){
                largest = actual;
            }
        }
        System.out.println(smallest + " " + largest);
    }
}
