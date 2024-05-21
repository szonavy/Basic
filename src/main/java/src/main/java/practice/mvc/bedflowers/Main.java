package practice.mvc.bedflowers;

import practice.a_common.MyFileReader;
import practice.a_common.MyFileWriter;
import practice.mvc.bedflowers.controller.FlowerbedManager;
import practice.mvc.bedflowers.model.Beds;

import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_IN = "src/main/java/src/main/resources/resources/complextasks/flowerbeds/felajanlas.txt";
    private static final String FILE_OUT = "src/main/java/src/main/resources/resources/complextasks/flowerbeds/result.txt";

    public static void main(String[] args) {
        MyFileReader reader = new MyFileReader(FILE_IN);
        List<String> row = reader.readLines();
        FlowerbedManager manager = new FlowerbedManager(row);

        System.out.println("Task 1:");
        System.out.println(manager.detail);

        System.out.println("\nTask 2:");
        System.out.println("Number of offerings: " + manager.getTheNumberOfOffering());

        System.out.println("\nTask 3:");
        System.out.println(manager.getTheBothSideUsers());

        System.out.println("\nTask 4:");
        int bed = 100;
        System.out.println("a; Number of offers: " + manager.getTheNumberOfRequestedBed(bed));
        System.out.println("The color of the flower bed, if only the first one plants: " + manager.getTheColorOfRequestedBed(bed));
        System.out.println("The all colors of the requested bed: " + manager.getTheAllColorsOfBed(bed));

        System.out.println("\nTask 5:");
        System.out.println(manager.getTheOffer());

        System.out.println("\nTask 6:");
        MyFileWriter writer = new MyFileWriter(FILE_OUT);
        Map<Integer, Beds> result = manager.getTheResult();
        for(Integer a : result.keySet()){
            writer.writeIntoFile(result.get(a).color + " " + result.get(a).offerId + "\n");
        }


        System.out.println(manager.getTheResult());
    }
}
