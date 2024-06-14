package practice.mvc.beacon.controller;

import practice.mvc.beacon.model.BeaconDetails;
import practice.mvc.beacon.model.LeftOut;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class BeaconController {
    public List<BeaconDetails> signal = new ArrayList<>();

    public BeaconController(List<String> row) {
        fillTheDetails(row);
    }
    public void fillTheDetails(List<String> row){
        for(String s : row) {
            String[] cutTheRow = s.split(" ");
            LocalTime time = LocalTime.of(Integer.parseInt(cutTheRow[0]),Integer.parseInt(cutTheRow[1]),Integer.parseInt(cutTheRow[2]));
            signal.add(new BeaconDetails(time,Integer.parseInt(cutTheRow[3]),Integer.parseInt(cutTheRow[4])));
        }
    }
    public BeaconDetails getTheDetails(int requestedId){
        return signal.get(requestedId -1);
    }

    public int elapsedTime(LocalTime firstTime, LocalTime secondTime){

        int sec = 0;
        if(firstTime.isAfter(secondTime)){

            sec = firstTime.toSecondOfDay() - secondTime.toSecondOfDay();
        }else {
            sec = secondTime.toSecondOfDay() - firstTime.toSecondOfDay();
        }
        return sec;
    }

    public LocalTime getTheDifferencesInSeconds(){
        BeaconDetails first = signal.get(0);
        BeaconDetails last = signal.get(signal.size() -1);
        int value = elapsedTime(first.time,last.time);
        return LocalTime.ofSecondOfDay(value);
    }

    public List<Integer> getCoordinates(){
        List<Integer> coordinates = new ArrayList<>();
        int smallestX = Integer.MAX_VALUE;
        int smallestY  = Integer.MAX_VALUE;
        int largestX = Integer.MIN_VALUE;
        int largestY = Integer.MIN_VALUE;
        for (BeaconDetails d : signal) {
            if(d.x > largestX){
                largestX = d.x;
            }
            if(d.x < smallestX){
                smallestX = d.x;
            }
            if(d.y > largestY){
                largestY = d.y;
            }
            if(d.y < smallestY){
                smallestY = d.y;
            }

        }
        coordinates.add(smallestX);
        coordinates.add(smallestY);
        coordinates.add(largestX);
        coordinates.add(largestY);

        return coordinates;
    }
    public double getMovements(int oneX, int oneY, int secondX, int secondY){
        return Math.sqrt(((oneX - secondX) * (oneX - secondX)) + ((oneY - secondY) * (oneY - secondY)));
    }

    public double countTheMovements(){
        double allMovements = 0;
        for(int i = 0; i < signal.size()-1; i++){
            allMovements += getMovements(signal.get(i).x, signal.get(i).y, signal.get(i+1).x, signal.get(i+1).y);
        }
        return allMovements;
    }

    public List<LeftOut> getTheLeftOutDetails(){
        List<LeftOut> deviations = new ArrayList<>();
        for(int i = 0; i < signal.size()-1; i++){

            int deviationX = Math.abs((signal.get(i).x - signal.get(i+1).x));
            int deviationY = Math.abs((signal.get(i).y - signal.get(i+1).y));
            if(deviationX >= 10 || deviationY >= 10){
                if(deviationX >= deviationY){
                    deviations.add(new LeftOut( signal.get(i+1),"coordinate deviation",deviationX));
                }else{
                    deviations.add(new LeftOut( signal.get(i+1),"coordinate deviation",deviationY));
                }
            }

            if(signal.get(i).time.plusMinutes(5).getSecond() < signal.get(i+1).time.getSecond()){
                int deviationTime = signal.get(i+1).time.getSecond() - signal.get(i).time.getSecond();
                deviations.add(new LeftOut( signal.get(i+1),"time deviation",deviationTime));
            }
        }
        return deviations;
    }
}
