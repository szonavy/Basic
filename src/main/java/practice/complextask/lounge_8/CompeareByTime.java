package practice.complextask.lounge_8;

import java.util.Comparator;

public class CompeareByTime implements Comparator<LoungeData> {
    @Override
    public int compare(LoungeData o1, LoungeData o2) {
        if(o1.hr == o2.hr){
            return Integer.compare(o1.min,o2.min);
        }else{
            return Integer.compare(o1.hr,o2.hr);
        }
    }
}
