package practice.complextask.conveyorbelt_7;

public class ConveyorBeltData {
    int deliveryId;
    int startTime;
    int packageStartLocation;
    int packageEndLocation;
    int packageWeight;
    int sumTime;
    int lengthOfTheBelt;

    public static int deliveryCount = 1;

    public ConveyorBeltData(int startTime, int packageStartLocation, int packageEndLocation, int packageWeight, int basicTime, int lengthOfTheBelt) {
        this.startTime = startTime;
        this.packageStartLocation = packageStartLocation;
        this.packageEndLocation = packageEndLocation;
        this.packageWeight = packageWeight;
        this.lengthOfTheBelt = lengthOfTheBelt;

        if(packageStartLocation <= packageEndLocation){
            sumTime = startTime + (packageEndLocation - packageStartLocation) * basicTime;
        }else{
            sumTime = startTime + ((lengthOfTheBelt - packageStartLocation) + packageEndLocation) * basicTime;
            //sumTime = startTime + (packageStartLocation - packageEndLocation) * basicTime;
        }
        this.deliveryId = deliveryCount++;
    }

    @Override
    public String toString() {
        return "ConveyorBeltData{" +
                "deliveryId=" + deliveryId +
                ", startTime=" + startTime +
                ", packageStartLocation=" + packageStartLocation +
                ", packageEndLocation=" + packageEndLocation +
                ", packageWeight=" + packageWeight +
                ", sumTime=" + sumTime +
                ", lengthOfTheBelt=" + lengthOfTheBelt +
                '}';
    }
}
