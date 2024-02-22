package practice.complextask.schedule_5;

import java.util.Comparator;

public class TrainDetails{
    int trainId;
    int stationId;
    int hr;
    int min;
    String departureOrArrive;

    public TrainDetails(int trainId, int stationId, int hr, int min, String departureOrArrive) {
        this.trainId = trainId;
        this.stationId = stationId;
        this.hr = hr;
        this.min = min;
        this.departureOrArrive = departureOrArrive;
    }

    @Override
    public String toString() {
        return "TrainDetails{" +
                "trainId=" + trainId +
                ", stationId=" + stationId +
                ", hr=" + hr +
                ", min=" + min +
                ", departureOrArrive='" + departureOrArrive + '\'' +
                '}';
    }



}
