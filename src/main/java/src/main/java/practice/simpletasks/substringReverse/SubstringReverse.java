package practice.simpletasks.substringReverse;

public class SubstringReverse {
    public static void main(String[] args) {

        String A = "madam";
        int l = A.length();
        int count = 0;
        for(int i = 0; i <= l/2;i++){
            if(A.charAt(i) == A.charAt((l-1) - i)){
                count++;
                System.out.println(A.charAt(i)+ " " + A.charAt((l-1)-i));
            }else{
                System.out.println("Nooooo:  " + A.charAt(i)+ " " + A.charAt((l-1)-i));
            }
        }
        if(count == l/2 + 1){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
