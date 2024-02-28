package practice.complextask.camps_10;

public class StudentsPreferences {
    CampDate startCampDate;
    CampDate endCampDate;
    String program;

    public StudentsPreferences(CampDate startCampDate, CampDate endCampDate, String program) {
        this.startCampDate = startCampDate;
        this.endCampDate = endCampDate;
        this.program = program;
    }

    @Override
    public String toString() {
        return "StudentsPreferences{" +
                "startCampDate=" + startCampDate +
                ", endCampDate=" + endCampDate +
                ", program='" + program + '\'' +
                '}';
    }
}
