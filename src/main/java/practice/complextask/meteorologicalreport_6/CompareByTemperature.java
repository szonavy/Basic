package practice.complextask.meteorologicalreport_6;

import java.util.Comparator;

public class CompareByTemperature implements Comparator<MetReportData> {
    @Override
    public int compare(MetReportData o1, MetReportData o2) {
        return Integer.compare(o1.temperature,o2.temperature);
    }
}
