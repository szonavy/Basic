package practice.complextask.meteorologicalreport;

import java.util.Comparator;

public class CompareByLocationAndTime implements Comparator<MetReportData> {
    @Override
    public int compare(MetReportData o1, MetReportData o2) {
        if(o1.location.equals(o2.location)){
            if(o1.time.hr == o2.time.hr){
                return Integer.compare(o1.time.sec,o2.time.sec);
            }else{
                return Integer.compare(o1.time.hr,o2.time.hr);
            }

        }else{
            return o1.location.compareTo(o2.location);
        }
    }
}
