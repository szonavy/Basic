package practice.mvc.bedflowers.model;

import java.util.Comparator;

public class CompareById implements Comparator<FlowerbedDetails> {
    public int compare(FlowerbedDetails o1, FlowerbedDetails o2) {
        return Integer.compare(o1.id,o2.id);
    }
}
