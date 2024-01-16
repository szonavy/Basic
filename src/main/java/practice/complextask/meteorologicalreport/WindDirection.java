package practice.complextask.meteorologicalreport;

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
