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

    public Map<TrainDetails, Integer> theMostWaitTimeTrain(){
        Map<TrainDetails, Integer> result = new HashMap<>();
        Collections.sort(details,new ComparatorByTrain());
        System.out.println(details);
        int maximum = Integer.MIN_VALUE;
        TrainDetails train = null;
        for(int i = 0; i < details.size()-1; i++){
            int oneTrainTime = convertToMin(details.get(i).hr,details.get(i).min);
            int anotherTrainTime = convertToMin(details.get(i+1).hr,details.get(i+1).min);

            if(details.get(i).stationId == details.get(i+1).stationId && details.get(i).departureOrArrive.equals("E") && details.get(i+1).departureOrArrive.equals("I")){
                if(maximum < (anotherTrainTime - oneTrainTime)){
                    maximum = (anotherTrainTime - oneTrainTime);
                    train = details.get(i);
                }
            }
        }
        result.put(train,maximum);
        return result;
    }

    public int lastTimeOfTheRequestedTrain(int tr){
        int last = 0;
        for (TrainDetails d : details) {
            if(d.trainId == tr){
                last = convertToMin(d.hr,d.min);
            }
        }
        return last;
    }
    public int findTheStartOfTrain(int tr){
        return details.stream()
                .filter(m->m.trainId == tr)
                .mapToInt(l->convertToMin(l.hr,l.min))
                .findFirst()
                .orElse(0);
    }

    public String tellTheScheduleStatus(int tr, int hr, int min){
        String message = "";
        int prescribedSchedule = convertToMin(hr,min);
        int realSchedule = (lastTimeOfTheRequestedTrain(tr) - findTheStartOfTrain(tr));

        if(prescribedSchedule < realSchedule){
            message = "he journey of train number " +  tr + " was " +  (realSchedule - prescribedSchedule)  +" minutes longer than prescribed.";
        }else if (prescribedSchedule > realSchedule){
            message = "he journey of train number " +  tr + " was " +  (prescribedSchedule - realSchedule)  +" minutes shorter than prescribed.";
        }else{
            message = "The journey of train number " +  tr + " took exactly the prescribed time";
        }
        return message;
    }
    public List<String> scheduleOfTheArrivalTimeByTrain(int tr){
        List<String> schedule = new ArrayList<>();
        for(TrainDetails d : details){
            if(d.trainId == tr) {
                if (d.departureOrArrive.equals("E")) {
                    schedule.add(d.stationId + ".station: " + d.hr + ":" + d.min + " \n");
                }
            }
        }
        return schedule;
    }





}
