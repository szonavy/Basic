package practice.complextask.camps_10;

public class CampDate {
    int month;
    int day;

    public CampDate(int month, int day) {
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "CampDate{" +
                "month=" + month +
                ", day=" + day +
                '}';
    }
}
