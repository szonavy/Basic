package practice.complextask.meteorologicalreport;

public class MetReportData {
    String location;
    String time;
    String windDetail;
    int temperature;

    public MetReportData(String location, String time, String windDetail, int temperature) {
        this.location = location;
        this.time = time;
        this.windDetail = windDetail;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "MetReportData{" +
                "location='" + location + '\'' +
                ", time='" + time + '\'' +
                ", windDetail='" + windDetail + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
