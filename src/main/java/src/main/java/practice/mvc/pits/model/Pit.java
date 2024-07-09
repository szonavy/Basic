package practice.mvc.pits.model;

import java.util.List;

public class Pit {
    public int pitID;
    public int pitsStart;
    public int pitsStartIndex;
    public int pitsEndIndex;
    public List<Integer> pitDepths;
    public int pitEnd;
    public int volume;

    public Pit(int pitID, int pitsStart, int pitsStartIndex, int pitsEndIndex, List<Integer> pitDepths, int pitEnd, int volume) {
        this.pitID = pitID;
        this.pitsStart = pitsStart;
        this.pitsStartIndex = pitsStartIndex;
        this.pitsEndIndex = pitsEndIndex;
        this.pitDepths = pitDepths;
        this.pitEnd = pitEnd;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Pit{" +
                "pitID=" + pitID +
                ", pitsStart=" + pitsStart +
                ", pitsStartIndex=" + pitsStartIndex +
                ", pitsEndIndex=" + pitsEndIndex +
                ", pitDepths=" + pitDepths +
                ", pitEnd=" + pitEnd +
                ", volume=" + volume +
                '}';
    }
}
