package practice.complextask.absences_8;

import java.util.ArrayList;
import java.util.List;

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
                //sheet.add(new AttendanceSheet(date));
            }else{
                students = new AbsencesStudentsDetails(cuttingLines[0],cuttingLines[1],cuttingLines[2]);
                sheet.add(new AttendanceSheet(date,students));
            }
        }
    }

    public int countTheAbsencesStudents(){
        return sheet.get(sheet.size()-1).students.absencesId;
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
}
