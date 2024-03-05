package practice.complextask.signal;

import practice.a_common.MyFileReader;

import java.util.List;

public class SignalMain {
    static final String FILE_IN = "src/main/java/src/main/resources/resources/complextasks/signal/jel.txt";
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

    }
}
