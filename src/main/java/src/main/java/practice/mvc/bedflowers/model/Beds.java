package practice.mvc.bedflowers.model;

public class Beds {
    public String color;
    public int offerId;

    public Beds(String color, int offerId) {
        this.color = color;
        this.offerId = offerId;
    }

    @Override
    public String toString() {
        return "Beds{" +
                "color='" + color + '\'' +
                ", offerId=" + offerId +
                '}';
    }
}
