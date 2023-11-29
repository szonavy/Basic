package practice.complextask.tvseries;

public class TvSeriesData {
    String date;
    String name;
    String seasonEpisode;
    int time;
    int watched;

    public TvSeriesData(String date, String name, String seasonEpisode, int time, int watched) {
        this.date = date;
        this.name = name;
        this.seasonEpisode = seasonEpisode;
        this.time = time;
        this.watched = watched;
    }

    @Override
    public String toString() {
        return "TvSeriesData{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", seasonEpisode='" + seasonEpisode + '\'' +
                ", time=" + time +
                ", watched=" + watched +
                '}';
    }
}
