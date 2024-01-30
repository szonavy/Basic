package practice.complextask.conveyorbelt_7;

import java.util.*;
import java.util.stream.Collectors;

public class ConveyorBeltManager {
    List<ConveyorBeltData> data = new ArrayList<>();
    int lengthOfTheBelt = 0;
    int distanceInSec = 0;

    public ConveyorBeltManager(List<String> rows) {
       fileHandling(rows);
    }
    private void fileHandling(List<String> rows){
        String[] cuttingBasic = rows.get(0).split(" ");
        lengthOfTheBelt = Integer.parseInt(cuttingBasic[0]);
        distanceInSec = Integer.parseInt(cuttingBasic[1]);
        for(int i = 1; i < rows.size(); i++){
            String[] cuttingRow = rows.get(i).split(" ");
            int startTime = Integer.parseInt(cuttingRow[0]);
            int packageStartLocation = Integer.parseInt(cuttingRow[1]);
            int packageEndLocation = Integer.parseInt(cuttingRow[2]);
            int packageWeight = Integer.parseInt(cuttingRow[3]);

            data.add(new ConveyorBeltData(startTime,packageStartLocation,packageEndLocation,packageWeight,distanceInSec,lengthOfTheBelt));
        }
    }

    public int requestedDeliveryStartPlace(int requested){
        return data.stream()
                .filter(l->l.deliveryId == requested)
                .mapToInt(m->m.packageStartLocation)
                .findFirst().orElse(-1);
    }
    public int requestedDeliveryEndPlace(int requested){
        return data.stream()
                .filter(l->l.deliveryId == requested)
                .mapToInt(m->m.packageEndLocation)
                .findFirst().orElse(-1);
    }
    public int distance(int lBelt, int start, int end){
        int dist = 0;
        if(start <= end){
            dist = end - start;
        }else{
            dist = (lBelt - end) + start;
        }
        return dist;
    }

    public int getTheLongestDistance(){
       return data.stream()
                .mapToInt(l->distance(lengthOfTheBelt,l.packageStartLocation,l.packageEndLocation))
               .max()
               .orElse(-1);

    }

    public int sumWeightFromPlaceZero(int zero){
        return data.stream()
                .filter(l->l.packageStartLocation < lengthOfTheBelt && l.packageEndLocation > zero)
                .mapToInt(k->k.packageWeight)
                .sum();
    }

    public List<Integer> getPackageIdByRequestedTime(int time){
        return  data.stream()
                .filter(l->l.sumTime > time && l.startTime >= time)
                .map(k->k.deliveryId)
                .collect(Collectors.toList());
    }

    public Map<Integer, Integer> getWeightsByStartLocation(){
        Map<Integer, Integer> weightByLocation =  new HashMap<>();

        for(ConveyorBeltData d : data){

//            weightByLocation.put(d.packageStartLocation, d.packageWeight +
//                    ( weightByLocation.get(d.packageStartLocation) == null ? 0 :  weightByLocation.get(d.packageStartLocation) ));

            weightByLocation.put(d.packageStartLocation, d.packageWeight +
                    Optional.ofNullable(weightByLocation.get(d.packageStartLocation)).orElse(0) );
        }
        return weightByLocation;

    }
}
