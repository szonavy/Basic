package practice.complextask.receptionhr_4;

import java.util.Comparator;

public class ComparatorByDate implements Comparator<BookingDetails> {
    @Override
    public int compare(BookingDetails o1, BookingDetails o2) {
        if(o1.year == o2.year){
            if(o1.month == o2.month){
                if(o1.day == o2.day){
                    if(o1.hr == o2.hr){
                        return Integer.compare(o1.min,o2.min);
                    }else{
                        return Integer.compare(o1.hr,o2.hr);
                    }
                }else{
                    return Integer.compare(o1.day,o2.day);
                }
            }else{
                return Integer.compare(o1.month,o2.month);
            }
        }else{
            return Integer.compare(o1.year,o2.year);
        }
    }
}
