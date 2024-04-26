package practice.mvc.tvseries_1.model;

public class Time {
    int day;
    int hr;
    int min;

    public Time(int time) {
        day = time / (60 * 24);
        hr = (time - (day * 24 * 60)) / 60;
        min = time - ((hr * 60) + (day * 24 * 60));
    }

    @Override
    public String toString() {
        return "Time{" +
                "day=" + day +
                ", hr=" + hr +
                ", min=" + min +
                '}';
    }
}
