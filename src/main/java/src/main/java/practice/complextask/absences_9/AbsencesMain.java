package practice.complextask.absences_9;

import practice.a_common.MyFileReader;

import java.util.List;
import java.util.Scanner;

public class AbsencesMain {
    static final String FILE_IN = "src/main/java/resources/absences/naplo-2.txt";
    public static void main(String[] args) {

        MyFileReader reader = new MyFileReader(FILE_IN);
        List<String> rows = reader.readLines();
        AbsencesManager manager = new AbsencesManager(rows);

        System.out.println("\nTask 1:");
        System.out.println(manager.sheet);

        System.out.println("\nTask 2:");
        System.out.println("There are " + manager.countTheAbsencesStudents() + " notes in the sheet.");

        System.out.println("\nTask 3:");
        System.out.println("The certified absence was : " + manager.countCertifiedAbsenceThisYear());
        System.out.println("The not certified absence was : " + manager.countUnCertifiedAbsenceThisYear());

        System.out.println("\nTask 5:");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please give me a date as month like : 1");
        int month = sc.nextInt();
        System.out.println("Please give me a date as day like : 5");
        int day = sc.nextInt();
        System.out.println("That day was : " + manager.getTheDay(month,day));

        System.out.println("\nTask 6:");
        System.out.println("Please give me the name of the day like : Sunday: ");
        String nameDay = sc.next();
        int serialNumberOfSubject = sc.nextInt();
        System.out.println("At that time, a total of  " + manager.countTheAbsencesByDayAndSubject(nameDay,serialNumberOfSubject) + " hours of absence occurred.");

        System.out.println("\nTask 7: ");
        System.out.println(manager.getTheMostAbsenceStudents());





    }
}
