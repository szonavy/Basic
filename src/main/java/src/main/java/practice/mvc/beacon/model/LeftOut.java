package practice.mvc.beacon.model;

public class LeftOut {
    BeaconDetails beacon;
    String reason;
    int detail;

    public LeftOut(BeaconDetails beacon, String reason, int detail) {
        this.beacon = beacon;
        this.reason = reason;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "LeftOut{" +
                "beacon=" + beacon +
                ", reason='" + reason + '\'' +
                ", deviation=" + detail +
                '}';
    }
}
