package practice.complextask.signal;

import java.util.ArrayList;
import java.util.List;

public class SignalManager {
    List<SignalDetails> details = new ArrayList<>();

    public SignalManager(List<String> rows) {
        fileProcess(rows);
    }
    private void fileProcess(List<String> rows){

        for (String r :rows) {
            String[] cutTheRows =  r.split(" ");
            details.add(new SignalDetails(Integer.parseInt(cutTheRows[0]),Integer.parseInt(cutTheRows[1]),Integer.parseInt(cutTheRows[2]),Integer.parseInt(cutTheRows[3]),Integer.parseInt(cutTheRows[4])));
        }
    }
    public List<Integer> getTheCoordinates(int id){
        List<Integer> coordinates = new ArrayList<>();

       for(SignalDetails d : details){
           if(d.id == id){
               coordinates.add(d.x);
               coordinates.add(d.y);
               break;
           }
       }
       return coordinates;
    }

    private int transformToSec(int hr, int min, int sec){
        return (hr * 3600)  + (min * 60) + sec;
    }

    private int difference(int hr1, int min1, int sec1, int hr2, int min2, int sec2){
        if(hr1 < hr2 || (hr1 == hr2 && min1 < min2) || (hr1 == hr2 && min1 == min2 && sec1 < sec2)){
            return transformToSec(hr2,min2,sec2) - transformToSec(hr1,min1,sec1);
        }else{
            return transformToSec(hr1,min1,sec1) - transformToSec(hr2,min2,sec2);
        }
    }
    public String getDifferenceFirstAndLeastMeasuredDetails(){
        int diff = difference(details.get(0).hr,details.get(0).min,details.get(0).sec,details.get(details.size()-1).hr,details.get(details.size()-1).min,details.get(details.size()-1).sec);
        int hr = (diff / 3600);
        int min = (diff - (hr * 3600)) / 60;
        int sec = diff - ((hr * 3600) + (min * 60));
        return  hr + ":" + min + ":" + sec;
    }

    public int getTheSmallestX(){
        return details.stream()
                .mapToInt(l->l.x)
                .min()
                .orElse(-100);
    }
    public int getTheSmallestY(){
        return details.stream()
                .mapToInt(l->l.y)
                .min()
                .orElse(-100);
    }
    public int getTheLargestX(){
        return details.stream()
                .mapToInt(l->l.x)
                .reduce(0,Integer::max);
    }
    public int getTheLargestY(){
        return details.stream()
                .mapToInt(l->l.y)
                .reduce(0,Integer::max);
    }

    private double getTheDistanceBetweenTwoPlaces(int x1, int y1, int x2, int y2){
        return Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
    }

    public double getTheDistance(){
        double amount = 0;

        for (int i = 0; i < details.size() - 1; i++) {
             amount +=  getTheDistanceBetweenTwoPlaces(details.get(i).x,details.get(i).y,details.get(i+1).x,details.get(i+1).y);
        }
        return amount;
    }
    public List<SignalMessage> getTheReasonOfTheMissingSignal(){
        List<SignalMessage> signal = new ArrayList<>();
        String reasonCoordinates = "coordinates";
        int amountCoordinates = 0;
        String reasonTime = "time";
        int amountTime = 0;

        for(int i = 1; i < details.size(); i++){
            double res = getTheDistanceBetweenTwoPlaces(details.get(i-1).x,details.get(i-1).y,details.get(i).x,details.get(i).y);
            if(res > 10.0){
                amountCoordinates = (int) res / 10;
            }
            int diff = difference(details.get(i-1).hr,details.get(i-1).min,details.get(i-1).sec,details.get(i).hr,details.get(i).min,details.get(i).sec);
            if(diff > (5*60)){
                amountTime = diff / (5*60);
            }
            if(amountCoordinates > amountTime){
                signal.add(new SignalMessage(details.get(i).hr,details.get(i).min,details.get(i).sec,reasonCoordinates,amountCoordinates));
            }if(amountCoordinates < amountTime){
                signal.add(new SignalMessage(details.get(i).hr,details.get(i).min,details.get(i).sec,reasonTime,amountTime));
            }
        }
        return signal;
    }

}
