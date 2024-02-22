package practice.complextask.meteorologicalreport_6;

public class WindDirection {
    String direction;
    int strength;

    public WindDirection(String direction, int strength) {
        this.direction = direction;
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "WindDirection{" +
                "direction='" + direction + '\'' +
                ", strength=" + strength +
                '}';
    }
}
