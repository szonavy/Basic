package practice.complextask.etravel_6;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.List;

public class ETravelManager {
    List<ETravelData> data = new ArrayList<>();

    public ETravelManager(List<String> rows) {
        fileHandling(rows);

    }
    public void fileHandling(List<String> rows){

        for(String r : rows){
            String[] cuttingRow = r.split(" ");

            int busStopId = Integer.parseInt(cuttingRow[0]);
            int cardId = Integer.parseInt(cuttingRow[2]);

            data.add(new ETravelData(busStopId,new ETravelTime(cuttingRow[1]), cardId,cuttingRow[3],cuttingRow[4]));
        }
    }
    public int numberOgRejectedPassengers(){
        int count = 0;
        for(ETravelData d : data){

            if(d.numberOfTicket == 0 && d.typeOfTicket.equals("JGY")|| d.expirationDate != null ) {
                if (d.numberOfTicket == -1) {
                    if (d.expirationDate.year == d.takeOffTime.year) {
                        if (d.expirationDate.month == d.takeOffTime.month) {
                            if (d.expirationDate.day < d.takeOffTime.day) {
                                count++;
                            }
                        } else if (d.expirationDate.month < d.takeOffTime.month) {
                            count++;
                        }
                    } else if (d.expirationDate.year < d.takeOffTime.year) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
//    public int getTheMostUsedStopNumber(){
//        data.stream()
//                .map(k->k.busStopId)
//                .count()
//
//    }
}
