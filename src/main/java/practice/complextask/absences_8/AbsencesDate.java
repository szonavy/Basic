package practice.complextask.absences_8;

public class AbsencesDate {
    int month;
    int day;

    public AbsencesDate(int month, int day) {
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "AbsencesDate{" +
                "month=" + month +
                ", day=" + day +
                '}';
    }
}
