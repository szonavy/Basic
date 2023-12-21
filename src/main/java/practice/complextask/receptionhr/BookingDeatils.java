package practice.complextask.receptionhr;

public class BookingDeatils {
    int year;
    int month;
    int day;
    int hr;
    int min;

    public BookingDeatils(int year, int month, int day, int hr, int min) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hr = hr;
        this.min = min;
    }

    @Override
    public String toString() {
        return "BookingDeatils{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hr=" + hr +
                ", min=" + min +
                '}';
    }
}
