package practice.complextask.etravel_6;

import practice.a_common.MyFileReader;

import java.util.List;

public class ETravelMain {
    public static final String FILE_IN = "src/main/java/resources/etravel/utasadat.txt";
    public static void main(String[] args) {

        MyFileReader reader = new MyFileReader(FILE_IN);
        List<String> rows = reader.readLines();
        ETravelManager manager = new ETravelManager(rows);
        System.out.println("\nTask 2:");
        System.out.println("There are " + manager.data.size() + " passenger wanted to use this service.");

        System.out.println("\nTask 3:");
        System.out.println("There were " + manager.numberOfRejectedPassengers() + " people, whose can't use the bus.");
    }



}
