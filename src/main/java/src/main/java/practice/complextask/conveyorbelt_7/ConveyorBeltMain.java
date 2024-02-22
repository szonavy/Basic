package practice.complextask.conveyorbelt_7;

import practice.a_common.MyFileReader;

import java.util.List;

public class ConveyorBeltMain {

    static final String FILE_IN = "src/main/java/resources/conveyorbelt/szallit.txt";

    public static void main(String[] args) {

        MyFileReader reader = new MyFileReader(FILE_IN);
        List<String> rows = reader.readLines();
        ConveyorBeltManager manager = new ConveyorBeltManager(rows);
        System.out.println("\nTask 1:");
        System.out.println(manager.data);

        System.out.println("\nTask 2:");
        int deliveryId = 3;
        System.out.println("From where: " + manager.getRequestedDeliveryStartPlace(deliveryId));
        System.out.println("To where: " + manager.getRequestedDeliveryEndPlace(deliveryId));

        System.out.println("\nTask 4:");
        System.out.println(manager.getTheLongestDistance());

        System.out.println("\nTask 5:");
        System.out.println(manager.sumWeightFromLocation(0));

        System.out.println("\nTask 6:");
        System.out.println(manager.getPackageIdByRequestedTime(300));

        System.out.println("\nTask 7:");
        System.out.println(manager.getWeightsByStartLocation());




    }


}
