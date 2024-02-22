package practice.complextask.schedule_5;

import java.util.Comparator;

public class ComparatorByTrain implements Comparator<TrainDetails> {
    public int compare(TrainDetails o1, TrainDetails o2) {
        if(o1.trainId == o2.trainId){
            if(o1.hr == o2.hr){
                return Integer.compare(o1.min,o2.min);
            }else {
                return Integer.compare(o1.hr,o2.hr);
            }
        }else{
            return Integer.compare(o1.trainId,o2.trainId);
        }
    }
}
