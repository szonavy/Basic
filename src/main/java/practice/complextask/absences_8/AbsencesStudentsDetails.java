package practice.complextask.absences_8;

public class AbsencesStudentsDetails {
    String firstName;
    String lastName;
    String absences;
    int absencesId;

    static int id = 0;
    public AbsencesStudentsDetails(String firstName, String lastName, String absences) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.absences = absences;
        id++;
        absencesId = id;

    }

    @Override
    public String toString() {
        return "AbsencesStudentsDetails{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", absences='" + absences + '\'' +
                ", absencesId=" + absencesId +
                '}';
    }
}
