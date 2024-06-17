package practice.mvc.buildingtax;

import practice.a_common.MyFileReader;
import practice.a_common.MyFileWriter;
import practice.mvc.buildingtax.controller.BuildingTaxController;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static final String FILE_IN = "src/main/java/src/main/resources/resources/complextasks/buildingtax/utca.txt";
    public static final String FILE_OUT = "src/main/java/src/main/resources/resources/complextasks/buildingtax/tax.txt";

    public static void main(String[] args) {
        MyFileReader reader = new MyFileReader(FILE_IN);
        List<String> rows = reader.readLines();
        BuildingTaxController controller = new BuildingTaxController(rows);

        System.out.println("\nTask 1:");
        System.out.println(controller.buildings);

        System.out.println("\nTask 2:");
        System.out.println("There are " + controller.countTheBuildings() + " buildings in the file.");

        System.out.println("\nTask 3:");
        int id = 68396;
        List<String> address = controller.getTheRequestedOwnerAddress(id);
        if(address.size() != 0){
            for(String a : address){
                System.out.println(a);
            }
        }else{
            System.out.println("The id is not in the file.");
        }

        System.out.println("\nTask 5:");
        System.out.println("a; " + controller.getTheNumberOfOwnerByTax());
        System.out.println("b; " + controller.getTheNumberSectionByPlot());

        System.out.println("\nTask 6:");
        Map<String, Set<Character>> streets = controller.getTheStreetBySection();
        for(String s : streets.keySet()){
            if(streets.get(s).size() > 1){
                System.out.println(s);
            }
        }

        System.out.println("\nTask 7:");
        MyFileWriter writer = new MyFileWriter(FILE_OUT);
        Map<Integer, Integer> taxByOwner = controller.getTheTaxByOwner();
        for(Integer t : taxByOwner.keySet()){
            writer.writeIntoFile(t + " " + taxByOwner.get(t) + "\n");
        }
        System.out.println("The file is exist.");

    }




}
