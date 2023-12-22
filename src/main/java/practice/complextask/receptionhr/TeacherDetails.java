package practice.complextask.receptionhr;

import java.util.Comparator;

public class TeacherDetails implements Comparator<TeacherDetails> {
    String lastName;
    String firstName;
    int receptionHr;
    int receptionMin;
    BookingDetails parents;

    public TeacherDetails(String lastName, String firstName, int receptionHr, int receptionMin, BookingDetails parents) {
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

    @Override
    public int compare(TeacherDetails o1, TeacherDetails o2) {
        if(o1.lastName.equals(o2.lastName)){
            return o1.firstName.compareTo(o2.firstName);
        }else{
            return o1.lastName.compareTo(o2.lastName);
        }
    }
}
