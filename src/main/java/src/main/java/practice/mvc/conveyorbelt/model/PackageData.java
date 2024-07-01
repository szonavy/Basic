package practice.mvc.conveyorbelt.model;

public class PackageData {
    public int deliveryId;
    public int startTime;
    public int startPlace;
    public int endPlace;
    public int weight;

    public PackageData(int deliveryId, int startTime, int startPlace, int endPlace, int weight) {
        this.startTime = startTime;
        this.startPlace = startPlace;
        this.endPlace = endPlace;
        this.weight = weight;
        this.deliveryId = deliveryId;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getStartPlace() {
        return startPlace;
    }

    public int getEndPlace() {
        return endPlace;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "PackageData{" +
                "deliveryId=" + deliveryId +
                ", startTime=" + startTime +
                ", startPlace=" + startPlace +
                ", endPlace=" + endPlace +
                ", weight=" + weight +
                '}';
    }
}
