package practice.complextask.camps_10;

public class CampDetails {
    CampDate startDate;
    CampDate endDate;
    String students;
    String activity;

    public CampDetails(CampDate startDate, CampDate endDate, String students, String activity) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.students = students;
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "CampDetails{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", students='" + students + '\'' +
                ", activity='" + activity + '\'' +
                '}';
    }
}
