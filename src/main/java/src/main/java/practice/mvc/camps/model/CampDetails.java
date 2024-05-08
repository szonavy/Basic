package practice.mvc.camps.model;

public class CampDetails {
    public int startMonth;
    public int startDay;
    public int endMonth;
    public int endDay;
    public String students;
    public String campName;

    public CampDetails(int startMonth, int startDay, int endMonth, int endDay, String students, String campName) {
        this.startMonth = startMonth;
        this.startDay = startDay;
        this.endMonth = endMonth;
        this.endDay = endDay;
        this.students = students;
        this.campName = campName;
    }

    @Override
    public String toString() {
        return "CampDetails{" +
                "startMonth=" + startMonth +
                ", startDay=" + startDay +
                ", endMonth=" + endMonth +
                ", endDay=" + endDay +
                ", students='" + students + '\'' +
                ", campName='" + campName + '\'' +
                '}';
    }
}
