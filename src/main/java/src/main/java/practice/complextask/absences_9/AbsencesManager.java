package practice.complextask.absences_9;

import java.util.*;
import java.util.stream.Collectors;

public class AbsencesManager {
    List<AttendanceSheet> sheet = new ArrayList<>();

    public AbsencesManager(List<String> row) {
        fileOrganizes(row);
    }
    private void fileOrganizes(List<String> rows){
        AbsencesDate date = null;
        for (String s : rows) {

            AbsencesStudentsDetails students = null;
            String[] cuttingLines = s.split(" ");

            if(cuttingLines[0].equals("#")){
                date = new AbsencesDate(Integer.parseInt(cuttingLines[1]),Integer.parseInt(cuttingLines[2]));

            }else{
                students = new AbsencesStudentsDetails(cuttingLines[0],cuttingLines[1],cuttingLines[2]);
                sheet.add(new AttendanceSheet(date,students));
            }
        }
    }
    public int countTheAbsencesStudents(){
        return sheet.get(sheet.size()-1).students.studentId;
    }

    public int countCertifiedAbsenceThisYear(){
        return sheet.stream()
                .map(l->l.absenceDetails.countCertifiedAbsence)
                .reduce(0,Integer::sum);
    }
    public int countUnCertifiedAbsenceThisYear(){
        return sheet.stream()
                .map(l->l.absenceDetails.countUnCertifiedAbsence)
                .reduce(0,Integer::sum);
    }
    public String getTheDay(int month, int day){

        String[] nameOfDay = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        int[] numberOfTheDay = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 335};
        int index = (numberOfTheDay[month - 1] + day) % 7;

        return nameOfDay[index];
    }

    public long countTheAbsencesByDayAndSubject(String nameOfTheDay, int subject){

        return sheet.stream()
                .filter(l->getTheDay(l.date.month,l.date.day).equals(nameOfTheDay))
                .filter(k->k.absenceDetails.getValuesById(subject).equals("X") || k.absenceDetails.getValuesById(subject).equals("I"))
                .count();
    }

    public Map<String, Integer> collectTheStudentsAbsences(){
        Map<String, Integer> absences = new HashMap<>();

        for (AttendanceSheet d : sheet) {
            String name = d.students.firstName + " " + d.students.lastName;
            int abs = d.absenceDetails.countCertifiedAbsence + d.absenceDetails.countUnCertifiedAbsence;
            if(!absences.containsKey(name)){
                absences.put(name, abs);
            }else{
                absences.put(name,absences.get(name) + abs);
            }
        }
        return absences;
    }
    private int getTheMostAbsence(){
        Map<String, Integer> absences = collectTheStudentsAbsences();

        return absences.values()
                .stream()
                .reduce(0,Integer::max);
    }

    public List<String> getTheMostAbsenceStudents(){

        int max = getTheMostAbsence();
        Map<String, Integer> absences = collectTheStudentsAbsences();

        return absences.keySet()
                .stream()
                .filter(l->absences.get(l)== max)
                .collect(Collectors.toList());

    }



}
