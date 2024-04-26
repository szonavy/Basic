package practice.mvc.tvseries_1.model;

public class EpisodesAndName {
    public String epizodSzam;
    public String nev;

    public EpisodesAndName(String epizodSzam, String nev) {
        this.epizodSzam = epizodSzam;
        this.nev = nev;
    }

    @Override
    public String toString() {
        return "EpisodesAndName{" +
                "epizodSzam='" + epizodSzam + '\'' +
                ", nev='" + nev + '\'' +
                '}';
    }
}
