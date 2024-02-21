package practice.complextask.absences_8;

import practice.a_common.MyFileReader;

import java.util.List;

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

    }
}
