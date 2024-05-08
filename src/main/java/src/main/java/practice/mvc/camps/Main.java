package practice.mvc.camps;

import practice.a_common.MyFileReader;
import practice.mvc.camps.controlling.CampControlling;

import java.util.List;

public class Main {
    private static String FILE_IN = "src/main/java/src/main/resources/resources/complextasks/camps/taborok.txt";
    public static void main(String[] args) {
        MyFileReader reader = new MyFileReader(FILE_IN);
        List<String> rows = reader.readLines();
        CampControlling controlling = new CampControlling(rows);

        System.out.println("Task 1");
        System.out.println(controlling.details);

        System.out.println("\nTask 2:");
        System.out.println("The number od the camps: " + controlling.getTheNumberOfTheCamps());
        System.out.println("The theme of the first camp is : " + controlling.getTheFirstCampTheme());
        System.out.println("The theme of the last camp is : " + controlling.getTheLastCampTheme());
    }
}
