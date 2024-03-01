package practice.complextask.camps_10;

import java.util.Comparator;

public class CompareByDate implements Comparator<CampDetails> {
    @Override
    public int compare(CampDetails o1, CampDetails o2) {
        if(o1.startDate.month == o2.startDate.month){
            return Integer.compare(o1.startDate.day,o2.startDate.day);
        }else{
            return Integer.compare(o1.startDate.month,o2.startDate.month);
        }
    }
}
