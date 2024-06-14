package practice.mvc.beacon.model;

import java.time.LocalTime;

public class BeaconDetails {
    public LocalTime time;
    public int x;
    public int y;

    public BeaconDetails(LocalTime time, int x, int y) {
        this.time = time;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "BeaconDetails{" +
                "time=" + time +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
