package practice.complextask.absences_9;

public class AttendanceSheet {
    AbsencesDate date;
    AbsencesStudentsDetails students;
    AttendanceDetails absenceDetails;

    public AttendanceSheet(AbsencesDate date, AbsencesStudentsDetails students) {
        this.date = date;
        this.students = students;
        absenceDetails = new AttendanceDetails(students.absences);
    }

    @Override
    public String toString() {
        return "AttendanceSheet{" +
                "date=" + date +
                ", students=" + students +
                ", details=" + absenceDetails +
                '}';
    }
}
