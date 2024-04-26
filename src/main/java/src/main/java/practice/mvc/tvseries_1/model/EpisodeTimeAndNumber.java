package practice.mvc.tvseries_1.model;

public class EpisodeTimeAndNumber {
    public String name;
    public int time;
    public int count;

    public EpisodeTimeAndNumber(String name, int time, int count) {
        this.name = name;
        this.time = time;
        this.count = count;
    }

    @Override
    public String toString() {
        return "EpisodeTimeAndNumber{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", count=" + count +
                '}';
    }
}
