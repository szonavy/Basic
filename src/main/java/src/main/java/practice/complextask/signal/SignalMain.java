package practice.complextask.signal;

import practice.a_common.MyFileReader;
import practice.a_common.MyFileWriter;

import java.text.DecimalFormat;
import java.util.List;

public class SignalMain {
    static final String FILE_IN = "src/main/java/src/main/resources/resources/complextasks/signal/jel.txt";
    static final String FILE_OUT = "src/main/java/src/main/resources/resources/complextasks/signal/missingSignal.txt";
    public static void main(String[] args) {

        MyFileReader reader = new MyFileReader(FILE_IN);
        List<String> rows = reader.readLines();
        SignalManager manager = new SignalManager(rows);

        System.out.println("\nTask 1:");
        System.out.println(manager.details);

        System.out.println("\nTask 2:");
        System.out.println("Please give me the id: ");
        int id = 3;
        System.out.println("X: " + manager.getTheCoordinates(id).get(0) + " Y: " + manager.getTheCoordinates(id).get(1));

        System.out.println("\nTask 4:");
        System.out.println(manager.getDifferenceFirstAndLeastMeasuredDetails());

        System.out.println("\nTask 5:");
        System.out.println("Left down: " + manager.getTheSmallestX() + " " + manager.getTheSmallestY() + " upper right: " + manager.getTheLargestX() + " " + manager.getTheLargestY());

        System.out.println("\nTask 6:");
        DecimalFormat df = new DecimalFormat("#.###");
        System.out.print("Distance: " + df.format(manager.getTheDistance()));

        System.out.println("\nTask 7:");
        MyFileWriter writer = new MyFileWriter(FILE_OUT);
        List<SignalMessage> signal = manager.getTheReasonOfTheMissingSignal();

        for(SignalMessage m : signal){
            writer.writeIntoFile(m + "\n");
        }
    }
}
