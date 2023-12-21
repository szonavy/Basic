package practice.complextask.receptionhr;

public class TeacherDetails {
    String lastName;
    String firstName;
    int receptionHr;
    int receptionMin;
    BookingDeatils parents;

    public TeacherDetails(String lastName, String firstName, int receptionHr, int receptionMin, BookingDeatils parents) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.receptionHr = receptionHr;
        this.receptionMin = receptionMin;
        this.parents = parents;
    }

    @Override
    public String toString() {
        return "TeacherDetails{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", receptionHr=" + receptionHr +
                ", receptionMin=" + receptionMin +
                ", parents=" + parents +
                '}';
    }
}
