package practice.mvc.buildingtax;

import practice.a_common.MyFileReader;
import practice.mvc.buildingtax.controller.BuildingTaxController;

import java.util.List;

public class Main {
    public static final String FILE_IN = "src/main/java/src/main/resources/resources/complextasks/buildingtax/utca.txt";

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

    }




}
