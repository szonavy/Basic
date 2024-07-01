package practice.mvc.conveyorbelt;

import practice.a_common.MyFileReader;
import practice.a_common.MyFileWriter;
import practice.mvc.conveyorbelt.controller.ConveyorBeltController;

import java.util.List;
import java.util.Map;

public class Main {
    public static final String FILE_IN = "src/main/java/src/main/resources/resources/complextasks/conveyorbelt/szallit.txt";
    public static final String FILE_OUT = "src/main/java/src/main/resources/resources/complextasks/conveyorbelt/weight.txt";

    public static void main(String[] args) {
        MyFileReader reader = new MyFileReader(FILE_IN);
        List<String> row = reader.readLines();
        ConveyorBeltController controller = new ConveyorBeltController(row);

        System.out.println("\nTask 1:");
        System.out.println(controller.packages);

        System.out.println("\nTask 2:");
        int packageId = 3;
        System.out.println("From where: " + controller.requestedPackageStartPlace(packageId));
        System.out.println("To where: " + controller.requestedPackageDestinationPlace(packageId));

        System.out.println("\nTask 4:");
        System.out.println("The maximum length: " + controller.getMaxDeliveryLength());
        System.out.println("The id of the maximum traveled package: " + controller.getTheIdTheMaxDelivery());

        System.out.println("\nTask 5:");
        int place = 0;
        System.out.println(controller.getTheWeightOfPassesByTheRequestedPlace(place));

        System.out.println("\nTask 6:");
        int time = 300;
        List<Integer> packages = controller.getTheTravelingPackages(time);
        if(packages == null){
            System.out.println("There where not any package at that time");
        }else{
            System.out.println(packages);
        }

        System.out.println("\nTask 7:");
        System.out.println(controller.getTheWeightByStartPlace());
        MyFileWriter writer = new MyFileWriter(FILE_OUT);

        Map<Integer,Integer> weight = controller.getTheWeightByStartPlace();
        for (Integer i : weight.keySet()) {
           writer.writeIntoFile(i + " " + weight.get(i) + "\n");
        }


    }
}
