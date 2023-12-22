package practice.complextask.receptionhr;

import practice.a_common.MyFileReader;

import java.util.List;
import java.util.Scanner;

public class ReceptionMain {
    public static void main(String[] args) {
        String fileIn = "src/main/java/resources/complextasks/receptionhour/fogado.txt";
        MyFileReader reader = new MyFileReader(fileIn);
        List<String> row = reader.readLines();

        ReceptionManager manager = new ReceptionManager(row);
        System.out.println("\nTask 1:");
        System.out.println(manager.details);

        System.out.println("\nTask 2:");
        System.out.println("the number of the booking records are: " + manager.numberOfbookingRecords());

        System.out.println("\nTask 3:");
        System.out.println("Please give me teacher's name like: Nagy Ferenc");
        Scanner sc = new Scanner(System.in);
        String teacherLastName = sc.next();
        String teacherFirstName = sc.next();
        int appointments = manager.requestedTeacherBookedAppointments(teacherLastName,teacherFirstName);
        if(appointments == 0){
            System.out.println("There are no appointments for the specified name.");
        }else {
            System.out.println("There are " + appointments + " appointments with the specified teacher.");
        }
        




    }
}
