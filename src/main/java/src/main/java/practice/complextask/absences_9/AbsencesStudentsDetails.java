package practice.complextask.absences_9;

public class AbsencesStudentsDetails {
    String firstName;
    String lastName;
    String absences;
    int studentId;

    static int id = 0;
    public AbsencesStudentsDetails(String firstName, String lastName, String absences) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.absences = absences;
        id++;
        studentId = id;

    }

    @Override
    public String toString() {
        return "AbsencesStudentsDetails{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", absences='" + absences + '\'' +
                ", absencesId=" + studentId +
                '}';
    }
}
