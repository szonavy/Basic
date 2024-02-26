package practice.complextask.receptionhr_4;

import practice.a_common.MyFileReader;

import java.util.Collections;
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
        System.out.println("the number of the booking records are: " + manager.numberOfBookingRecords());

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

        System.out.println("\nTask 4:");
        System.out.println("Please give me an appointment like 17:40 : ");
        String time = sc.next();
        List<Integer> sepTime = manager.cutTheTime(time);
        List<String> first = manager.teachersSameAppointments(sepTime.get(0),sepTime.get(1));
        Collections.sort(first);
        System.out.println(first);

        System.out.println("\nTask 5:");
        TeacherDetails teacher = manager.findTheFirstBookedTeacherMeeting();
        System.out.println("The teacher's name is : " + teacher.lastName + " " + teacher.firstName);
        System.out.println("The booked time is : " + teacher.receptionHr + ":" + teacher.receptionMin);
        BookingDetails bookedDate = teacher.parents;
        System.out.println("The appointment was booked on: " + bookedDate.year + "." + bookedDate.month + "." + bookedDate.day + "-" + bookedDate.hr + ":" + bookedDate.min );

        System.out.println("\nTask 6:");
        String lName = "Barna";
        String fName = "Eszter";
        System.out.println(lName + " " + fName + " has the follow free appointments :");
        System.out.println(manager.requestedTeacherAppointments(lName,fName));
        System.out.println("The time when " + lName + " " + fName + " can leave the school at : " + manager.theTimeWhenTheTeacherLeft(lName,fName));









    }
}
