package practice.complextask.schedule_5;

import java.util.*;
import java.util.stream.Collectors;

public class TrainManager {
    List<TrainDetails> details;

    public TrainManager(List<String> row) {
        details = new ArrayList<>();
        fileHandling(row);

    }
    public void fileHandling(List<String> row){

        for (String r : row) {
            String[] cutTheRow = r.split("\\t");
            int trainId = Integer.parseInt(cutTheRow[0]);
            int stationId = Integer.parseInt(cutTheRow[1]);
            int hr = Integer.parseInt(cutTheRow[2]);;
            int min = Integer.parseInt(cutTheRow[3]);;
            String departureOrArrive = cutTheRow[4];

            details.add(new TrainDetails(trainId,stationId,hr,min,departureOrArrive));
        }
    }
    public int numberOfStations(){

       return details.stream()
                .map(m->m.stationId)
               .collect(Collectors.toSet())
               .size();
    }

    public int numberOfTrains(){
        return details.stream()
                .map(m->m.trainId)
                .collect(Collectors.toSet())
                .size();
    }
    public int convertToMin(int hr, int min){
        return (hr *60) + min;
    }

    public void TheMostWaitTimeTrain(){
        int maximum = Integer.MIN_VALUE;
        TrainDetails train = null;
        for(int i = 0; i < details.size()-1; i++){
            int oneTrainTime = convertToMin(details.get(i).hr,details.get(i).min);
            int anotherTrainTime = convertToMin(details.get(i+1).hr,details.get(i+1).min);

            if(maximum < (anotherTrainTime - oneTrainTime)){
                
            }
        }
    }



}
