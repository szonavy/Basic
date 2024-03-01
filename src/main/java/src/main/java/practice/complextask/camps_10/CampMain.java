package practice.complextask.camps_10;

import practice.a_common.MyFileReader;
import practice.a_common.MyFileWriter;

import java.util.List;

public class CampMain {
    final static String FILE_IN =  "src/main/java/src/main/resources/resources/complextasks/camps/taborok.txt";
    final static String FILE_OUT =  "src/main/java/src/main/resources/resources/complextasks/camps/student.txt";


    public static void main(String[] args) {
        MyFileReader reader = new MyFileReader(FILE_IN);
        List<String> rows = reader.readLines();
        CampManager manager = new CampManager(rows);
        System.out.println(manager.details);


        System.out.println("\nTask 2");
        System.out.println("The number of the details: " + manager.countTheDetails());
        System.out.println("The name of the first program is : " + manager.getTheFirstProgram());
        System.out.println("The name of the last program is : " + manager.getTheLastProgram());

        System.out.println("\nTask 3:");
        String requested = "zenei";
        List<CampDate> date = manager.getTheStartDatesOfTheMusicCamp(requested);
        if(date.size() == 0){
            System.out.println("There wasn't" + requested + " camp." );
        }else{
            for (CampDate d : date) {
                System.out.println("The " + requested + " starts on: " + d.month + " month " + d.day + " day.");
            }
        }

        System.out.println("\nTask 4:");
        List<CampDetails> interestedDetails = manager.getTheDetailsOfTheMostInterestedProgram();
        System.out.println("There is/are the most interested program(s): ");
        for(CampDetails d : interestedDetails){
            System.out.println(d.startDate.month + " " + d.startDate.day + " " + d.activity);
        }

        System.out.println("\nTask 6:");
        int reqMonth = 8;
        int reqDay = 1;
        System.out.println("There are " + manager.countTheCampsByTime(reqMonth,reqDay) + " camps at the same time.");

        System.out.println("\nTask 7:");

        Character student = 'A';
        MyFileWriter writer = new MyFileWriter(FILE_OUT);
        List<CampDetails> studentInterest = manager.studentInterests(student);
        for(CampDetails d : studentInterest){
            writer.writeIntoFile(d.startDate.month + "." + d.startDate.day + "-"+d.endDate.month + "." + d.endDate.day + "." + d.activity + "\n");
        }
        System.out.println(manager.participation(student));

    }
}
