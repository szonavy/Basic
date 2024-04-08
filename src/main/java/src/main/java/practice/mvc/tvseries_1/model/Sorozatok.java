package practice.mvc.tvseries_1.model;

public class Sorozatok {
    public int id;
    public String nev;
    public int hossz;

    public Sorozatok(int id, String nev, int hossz) {
        this.id = id;
        this.nev = nev;
        this.hossz = hossz;
    }

    @Override
    public String toString() {
        return "Sorozatok{" +
                "id=" + id +
                ", nev='" + nev + '\'' +
                ", hossz=" + hossz +
                '}';
    }
}
