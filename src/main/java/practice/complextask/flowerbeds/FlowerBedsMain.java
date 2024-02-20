package practice.complextask.flowerbeds;

import practice.a_common.MyFileReader;
import practice.a_common.MyFileWriter;

import java.util.List;
import java.util.Map;

public class FlowerBedsMain {
    static final String FILE_IN = "src/main/java/resources/flowerbeds/felajanlas.txt";
    static final String FILE_OUT =  "src/main/java/resources/flowerbeds/colors.txt";
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

        System.out.println("\nTask 4:");
        System.out.println("Please give me the id of bed: ");
        int bed =100;
        System.out.println("a; The number of offers, where the requested bed id is included:  " + manager.countOffersIncludedBed(bed));
        System.out.println("b; The color of the flower bed, if only the first one plants: " + manager.getTheColorOfTheRequestedBedByTheFirstOffer(bed));
        System.out.println("c; The color of the bed: " + manager.getTheColorOfTheRequestedBedByAllOffer(bed));

        System.out.println("\nTask 5:");
        System.out.println(manager.isPossibleToPlantAllBeds());

        System.out.println("\nTask 6:");
        MyFileWriter writer = new MyFileWriter(FILE_OUT);
        Map<Integer, Map<String,Integer>> colors = manager.getTheColorOfBedByNoOffers();

        for(Integer i : colors.keySet()){
            writer.writeIntoFile(colors.get(i) + "\n");
        }
    }
}
