package practice.complextask.signal;

public class SignalDetails {
    int id;
    int hr;
    int min;
    int sec;
    int x;
    int y;


    public static int count = 0;
    public SignalDetails(int hr, int min, int sec, int x, int y) {
        count++;
        this.id = count;
        this.hr = hr;
        this.min = min;
        this.sec = sec;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "SignalDetails{" +
                "hr=" + hr +
                ", min=" + min +
                ", sec=" + sec +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
