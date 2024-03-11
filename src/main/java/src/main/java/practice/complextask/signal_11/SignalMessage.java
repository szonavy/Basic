package practice.complextask.signal_11;

public class SignalMessage {
    int hr;
    int min;
    int sec;
    String reason;
    int amount;

    public SignalMessage(int hr, int min, int sec, String reason, int amount) {
        this.hr = hr;
        this.min = min;
        this.sec = sec;
        this.reason = reason;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "SignalMessage{" +
                "hr=" + hr +
                ", min=" + min +
                ", sec=" + sec +
                ", reason='" + reason + '\'' +
                ", amount=" + amount +
                '}';
    }
}
