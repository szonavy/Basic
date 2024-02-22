package practice.complextask.lounge_8;

import java.util.Comparator;

public class CompareById implements Comparator<LoungeData> {
    @Override
    public int compare(LoungeData o1, LoungeData o2) {
        return Integer.compare(o1.id,o2.id);
    }
}
