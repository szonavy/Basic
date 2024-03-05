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
        int x = 0;
        int y = 0;
       for(SignalDetails d : details){
           if(d.id == id){
               coordinates.add(d.x);
               coordinates.add(d.y);
               break;
           }
       }
       return coordinates;
    }
}
