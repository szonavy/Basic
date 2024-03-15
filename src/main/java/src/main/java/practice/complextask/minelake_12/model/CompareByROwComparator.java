package practice.complextask.minelake_12.model;

import java.util.Comparator;

public class CompareByROwComparator implements Comparator<MineLakeData> {
    @Override
    public int compare(MineLakeData o1, MineLakeData o2) {
        if(o1.row == o2.row){
            return Integer.compare(o1.column,o2.column);
        }else{
            return Integer.compare(o1.row,o2.row);
        }
    }
}
