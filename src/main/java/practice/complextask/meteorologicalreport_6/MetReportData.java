package practice.complextask.meteorologicalreport_6;

public class MetReportData {
    String location;
    MetReportTime time;
    WindDirection windDetail;
    int temperature;

    public MetReportData(String location, MetReportTime time, WindDirection windDetail, int temperature) {
        this.location = location;
        this.time = time;
        this.windDetail = windDetail;
        this.temperature = temperature;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public MetReportTime getTime() {
        return time;
    }

    public void setTime(MetReportTime time) {
        this.time = time;
    }

    public WindDirection getWindDetail() {
        return windDetail;
    }

    public void setWindDetail(WindDirection windDetail) {
        this.windDetail = windDetail;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
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
