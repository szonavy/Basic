package practice.complextask.lounge_8;





import practice.a_common.MyFileReader;
import practice.a_common.MyFileWriter;

import java.util.List;
import java.util.TreeMap;

public class LoungeMain {
    public static void main(String[] args) {
        String fileIn = "src/main/java/resources/lounge/ajto-1.txt";
        MyFileReader reader = new MyFileReader(fileIn);
        List<String> rows = reader.readLines();
        LoungeManager manager = new LoungeManager(rows);
        System.out.println(manager.data);

        System.out.println("\ntask 2:");
        System.out.println("The first person in the room: " + manager.theFirstPersonById());
        System.out.println("The last person, who came out from the room: " + manager.theLastPersonWhoLeftTheRoom());

        System.out.println("\nTask 3:");
        TreeMap<Integer,Integer> walk = manager.getNumberOfWalkThroughTheDoorById();
        String fileOut = "src/main/java/resources/lounge/passage.txt";
        MyFileWriter writer = new MyFileWriter(fileOut);

        for (Integer w : walk.keySet()) {
            writer.writeIntoFile(w + " " + walk.get(w) + "\n");
        }
        System.out.println("The file is exist.");

        System.out.println("\nTask 4:");
        System.out.println("Workers,who stayed at the lounge according to id: " + manager.getIdWhoStayedAtTheLounge().keySet());

        System.out.println("\nTask 5:");
        System.out.println("There were at " + manager.getTheMostPeopleTime().get().getKey() + " at the same time");

        System.out.println("\nTask 6:");
        System.out.println("Please give me an id:");
        int personalId = 22;

        System.out.println("\nTask 7:");
        List<LoungeData> reqData = manager.getDetailsAboutTheRequestedPerson(personalId);
        System.out.println(manager.getTheTimeWhenWasTheRequestedPersonInTheLounge(reqData));

        System.out.println("\nTask 8:");
        System.out.println("The " + personalId + ". person has spent " + manager.countTheStayedTime(reqData) + " minutes in the lounge.");
        System.out.println(manager.getThePersonStatus(reqData));







    }
}
