package practice.mvc.camps;

import practice.a_common.MyFileReader;
import practice.mvc.camps.controlling.CampControlling;
import practice.mvc.camps.model.CampDetails;

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

        System.out.println("\nTask 3:");
        String name = "zenei";
        List<CampDetails> camps = controlling.getTheRequestedCampDetails(name);
        if(camps.isEmpty()){
            System.out.println("There weren't any camp in the requested theme.");
        }else {
            for (CampDetails c : camps) {
                System.out.println("The " + name + " camps going to start " + c.startMonth + ".month " + c.startDay + ".day");
            }
        }

        System.out.println("\nTask 4:");
        System.out.println("The most interested camps are: ");
        List<CampDetails> detail = controlling.getTheMostInterestedCampDetails();
        for (CampDetails c : detail) {
            System.out.println(c.startMonth + " " + c.startDay + " " + c.campName);
        }

    }
}
