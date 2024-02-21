package practice.complextask.absences_8;

public class AttendanceDetails {
    String first;
    String second;
    String third;
    String fourth;
    String fifth;
    String sixth;
    String seventh;
    int countPresent;
    int countNotHaveClass;
    int countCertifiedAbsence;
    int countUnCertifiedAbsence;

    public AttendanceDetails(String studentsAbsence) {

        this.first = studentsAbsence.substring(0,1);
        this.second = studentsAbsence.substring(1,2);
        this.third = studentsAbsence.substring(2,3);
        this.fourth = studentsAbsence.substring(3,4);
        this.fifth = studentsAbsence.substring(4,5);
        this.sixth = studentsAbsence.substring(5,6);
        this.seventh = studentsAbsence.substring(6,7);

        countTheAbsences(studentsAbsence);

    }
    private void countTheAbsences(String studentClass){

        for(int i = 0; i < studentClass.length(); i++){
            if(studentClass.charAt(i) == 'O'){
                countPresent++;
            }
            if(studentClass.charAt(i) == 'N'){
                countNotHaveClass++;
            }
            if(studentClass.charAt(i) == 'X'){
                countCertifiedAbsence++;
            }
            if(studentClass.charAt(i) == 'I'){
                countUnCertifiedAbsence++;
            }
        }
    }

    @Override
    public String toString() {
        return "AttendanceDetails{" +
                "first='" + first + '\'' +
                ", second='" + second + '\'' +
                ", third='" + third + '\'' +
                ", fourth='" + fourth + '\'' +
                ", fifth='" + fifth + '\'' +
                ", sixth='" + sixth + '\'' +
                ", seventh='" + seventh + '\'' +
                ", countPresent=" + countPresent +
                ", countNotHaveClass=" + countNotHaveClass +
                ", countCertifiedAbsence=" + countCertifiedAbsence +
                ", countUnCertifiedAbsence=" + countUnCertifiedAbsence +
                '}';
    }
}
