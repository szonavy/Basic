package practice.complextask.flowerbeds;

import practice.a_common.MyFileReader;

import java.util.List;

public class FlowerBedsMain {
    static final String FILE_IN = "src/main/java/resources/flowerbeds/felajanlas.txt";
    public static void main(String[] args) {

        MyFileReader reader = new MyFileReader(FILE_IN);
        List<String> rows = reader.readLines();
        FlowerBeadsController manager = new FlowerBeadsController(rows);

        System.out.println("\nTask 1:");
        System.out.println(manager.data);

        System.out.println("\nTask 2:");
        System.out.println("The number of offers: " + manager.getNumberOfOffers());

        System.out.println("\nTask 3:");
        System.out.println("Planters on both side of the entrance: " + manager.getPlantersIdOnBothSideOfBeds() );


    }
}
