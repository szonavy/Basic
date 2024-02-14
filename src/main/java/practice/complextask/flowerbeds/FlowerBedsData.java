package practice.complextask.flowerbeds;

public class FlowerBedsData {
    int id;
    int startBedLocation;
    int endBedLocation;
    String color;

    static int counter = 0;

    public FlowerBedsData( int startBedLocation, int endBedLocation, String color) {
        counter++;
        this.id = counter;
        this.startBedLocation = startBedLocation;
        this.endBedLocation = endBedLocation;
        this.color = color;
    }

    @Override
    public String toString() {
        return "FlowerBedsData{" +
                "id=" + id +
                ", startBedLocation=" + startBedLocation +
                ", endBedLocation=" + endBedLocation +
                ", color='" + color + '\'' +
                '}';
    }
}
