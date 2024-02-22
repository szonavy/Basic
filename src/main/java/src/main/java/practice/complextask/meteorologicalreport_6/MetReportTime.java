package practice.complextask.meteorologicalreport_6;

public class MetReportTime {
    int hr;
    int sec;

    public MetReportTime(int hr, int sec) {
        this.hr = hr;
        this.sec = sec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetReportTime that = (MetReportTime) o;

        if (hr != that.hr) return false;
        return sec == that.sec;
    }

    @Override
    public int hashCode() {
        int result = hr;
        result = 31 * result + sec;
        return result;
    }

    @Override
    public String toString() {
        return
                hr +
                ":" + sec;
    }
}
