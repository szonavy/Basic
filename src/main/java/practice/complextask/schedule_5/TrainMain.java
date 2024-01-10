package practice.complextask.schedule_5;

import practice.a_common.MyFileReader;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

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

        System.out.println("\nTask 3:");
        Map<TrainDetails,Integer> train = manager.theMostWaitTimeTrain();
        System.out.println("The train details are: " + train.keySet()+ " and the waiting time was: " + train.values() + " minutes");

        System.out.println("\nTask 4:");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please give me the number of the train:");
        int trainNr = sc.nextInt();
        System.out.println("Please give me the hr: ");
        int hr = sc.nextInt();
        System.out.println("Please give me the minute: ");
        int min = sc.nextInt();

        System.out.println("\nTask 5:");
        System.out.println(manager.tellTheScheduleStatus(trainNr,2,22));

        System.out.println("\nTask 6:");
        System.out.println(manager.scheduleOfTheArrivalTimeByTrain(trainNr));




    }
}
