package practice.mvc.beacon.model;

import practice.a_common.MyFileReader;
import practice.a_common.MyFileWriter;
import practice.mvc.beacon.controller.BeaconController;

import java.text.DecimalFormat;
import java.time.Instant;
import java.util.List;

public class Main {
    public static final String FILE_IN = "src/main/java/src/main/resources/resources/complextasks/signal/jel.txt";
    public static final String FILE_OUT = "src/main/java/src/main/resources/resources/complextasks/signal/deviation.txt";

    public static void main(String[] args) {
        MyFileReader reader = new MyFileReader(FILE_IN);
        List<String> row = reader.readLines();

        BeaconController controller = new BeaconController(row);

        System.out.println("\nTask 1:");
        System.out.println(controller.signal);

        System.out.println("\nTask 2:");
        int id = 3;
        System.out.println("x:" + controller.getTheDetails(id).x + " y:" + controller.getTheDetails(id).y);

        System.out.println("\nTask 4:");
        System.out.println("Duration is: " + controller.getTheDifferencesInSeconds());

        System.out.println("\nTask 5:");
        List<Integer> coordinates = controller.getCoordinates();
        System.out.println("Left down: " + coordinates.get(0) + " " + coordinates.get(1) + " Right up: " +  coordinates.get(2) + " " + coordinates.get(3));

        System.out.println("\nTask 6:");
        DecimalFormat df = new DecimalFormat("###.###");
        System.out.printf("Movements: " + df.format(controller.countTheMovements()));

        System.out.println("\nTask 7:");
        MyFileWriter writer = new MyFileWriter(FILE_OUT);
        List<LeftOut> deviations = controller.getTheLeftOutDetails();
        for(LeftOut l : deviations){
            writer.writeIntoFile(l.beacon.time + " " + l.reason + " " + l.detail + "\n");
        }
        System.out.println(controller.getTheLeftOutDetails());
    }
}
