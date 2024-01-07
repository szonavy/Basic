package practice.complextask.schedule_5;

import practice.a_common.MyFileReader;

import java.util.List;

public class TrainMain {
    public static void main(String[] args) {

        String fileIn = "src/main/java/resources/complextasks/schedule/vonat.txt";

        MyFileReader reader = new MyFileReader(fileIn);
        List<String> row = reader.readLines();

        TrainManager manager = new TrainManager(row);

        System.out.println("Task 1:");
        System.out.println(manager.details);

        System.out.println("\nTask 2:");
        System.out.println("The numbers of the stations are: " + manager.numberOfStations());
        System.out.println("The numbers of the trains are: " + manager.numberOfTrains());


    }
}
