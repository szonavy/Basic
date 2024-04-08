package practice.mvc.tvseries_1.model;

import java.time.LocalDate;

public class Epizod {
    public int id;
    public int sorozatId;
    public LocalDate megjelenes;
    public String epizodSzam;
    public boolean megnezett;

    public Epizod(int id, int sorozatId, LocalDate megjelenes, String epizodSzam, boolean megnezett) {
        this.id = id;
        this.sorozatId = sorozatId;
        this.megjelenes = megjelenes;
        this.epizodSzam = epizodSzam;
        this.megnezett = megnezett;
    }

    @Override
    public String toString() {
        return "Epizod{" +
                "id=" + id +
                ", sorozatId=" + sorozatId +
                ", megjelenes=" + megjelenes +
                ", epizodSzam='" + epizodSzam + '\'' +
                ", megnezett=" + megnezett +
                '}';
    }
}
