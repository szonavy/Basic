package practice.complextask.subject_2;

import practice.a_common.MyFileReader;

import java.util.*;

public class SubjectManager {

    public static void main(String[] args) {
        String fileIn = "src/main/java/resources/complextasks/subjects/beosztas.txt";

        MyFileReader reader = new MyFileReader(fileIn);
        List<String> row = reader.readLines();
        List<SubjectAdministration> data = new ArrayList<>();

        String name;
        String subject;
        String schoolClass;
        int subjectNumber;
        for(int i = 0; i < row.size()-3; i+=4){
            name = row.get(i);
            subject = row.get(i+1);
            schoolClass = row.get(i+2);
            subjectNumber = Integer.parseInt(row.get(i+3));
            data.add(new SubjectAdministration(name,subject,schoolClass,subjectNumber));
        }
        System.out.println("\nTask 1:");
        System.out.println(data);

        System.out.println("\nTask 2:");
        System.out.println("There are " + data.size() + " entries in the file.");

        System.out.println("\nTask 3:");
        int count = 0;
        for(SubjectAdministration a : data){
            count += a.subjectNumber;
        }
        System.out.println("The teaching hrs int the school are " + count + " per week.");

        System.out.println("\nTask 4:");
        System.out.println("Please give me teacher's name, like: 'Albatrosz Aladin");
        Scanner sc = new Scanner(System.in);
        String requestedName = sc.nextLine();
        int countTheHr = 0;

        for(SubjectAdministration da : data){
            if(da.name.equals(requestedName)){
                countTheHr += da.subjectNumber;
            }
        }
        System.out.println("The teacher " + requestedName + " taught " + countTheHr + " hrs last week.");

        System.out.println("\nTask 5:");
        Map<String, String> formerTeacher = new HashMap<>();

        for(SubjectAdministration da : data){
            if(da.subject.equals("osztalyfonoki")){
                formerTeacher.put(da.schoolClass,da.name);
            }
        }

        for(String f : formerTeacher.keySet()){
            System.out.println(f + "-" + formerTeacher.get(f));
        }

        System.out.println("\nTask 6:");
        System.out.println("Please give me class and a subject, like: \n10.b \nkemia");

        String requestedClass = sc.next();
        String requestedSubject = sc.next();

        int countDistribution = 0;
        for(SubjectAdministration da : data){
            if(da.schoolClass.equals(requestedClass) && da.subject.equals(requestedSubject)){
                countDistribution++;
            }
        }
        if(countDistribution > 1){
            System.out.println("The specified class studies the given subject in groups.");
        }else{
            System.out.println("The specified class studies the given subject at the class level");
        }

        System.out.println("\nTask 7:");
        Set<String> teachers = new HashSet<>();

        for(SubjectAdministration da : data){
            teachers.add(da.name);
        }
        System.out.println("There are " + teachers.size() + " teachers work in the school.");




    }
}
