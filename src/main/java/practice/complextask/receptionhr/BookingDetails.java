package practice.complextask.receptionhr;

import java.util.Comparator;

public class BookingDetails {
    int year;
    int month;
    int day;
    int hr;
    int min;

    public BookingDetails(int year, int month, int day, int hr, int min) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookingDetails that = (BookingDetails) o;

        if (year != that.year) return false;
        if (month != that.month) return false;
        if (day != that.day) return false;
        if (hr != that.hr) return false;
        return min == that.min;
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + month;
        result = 31 * result + day;
        result = 31 * result + hr;
        result = 31 * result + min;
        return result;
    }
}
