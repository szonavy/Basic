package practice.complextask.lounge_8;

import java.util.*;
import java.util.stream.Collectors;

public class LoungeManager {
    List<LoungeData> data = new ArrayList<>();

    public LoungeManager(List<String> rows) {
        fileHandling(rows);
    }

    private void fileHandling(List<String> rows){

        for (String r : rows) {
            String[] cutTheRows = r.split(" ");
            data.add(new LoungeData(Integer.parseInt(cutTheRows[0]),Integer.parseInt(cutTheRows[1]),Integer.parseInt(cutTheRows[2]),cutTheRows[3]));
        }
    }

    public int theFirstPersonById(){
        return data.get(0).id;
    }

    public int theLastPersonWhoLeftTheRoom(){
        Collections.reverse(data);

        return data.stream()
                .filter(l-> !l.stayedOrNot)
                .mapToInt(m->m.id)
                .findFirst()
                .getAsInt();
    }

    public TreeMap<Integer,Integer> getNumberOfWalkThroughTheDoorById(){
        TreeMap<Integer,Integer> walk = new TreeMap<>();

        for (LoungeData d : data) {
            if(!walk.containsKey(d.id)){
                walk.put(d.id,1);
            }else{
                walk.put(d.id,walk.get(d.id)+1);
            }
        }
        return walk;
    }

    public Map<Integer,Boolean> getIdWhoStayedAtTheLounge(){
        Collections.sort(data, new CompeareByTime());
        Map<Integer,Boolean> stayed = new HashMap<>();

        for(LoungeData d : data){
            stayed.put(d.id,d.stayedOrNot);
        }

        stayed.values().removeIf(s->!s);
        return stayed;
    }

    public Map<String,List<LoungeData>> collectPersonsByTime(){
        Map<String,List<LoungeData>> time = new HashMap<>();

        Collections.sort(data,new CompeareByTime());
        for (LoungeData d : data) {
            if(d.stayedOrNot) {
                time.computeIfAbsent(d.hr + ":" + d.min, k -> new ArrayList<>()).add(d);
            }
        }
        return time;
    }

    public int getTheMostPeopleInTheRoomByTime(){
        Map<String,List<LoungeData>> time = collectPersonsByTime();
        return time.entrySet().stream()
                .mapToInt(l->l.getValue().size())
                .max().orElse(0);
    }

    public Optional<Map.Entry<String, List<LoungeData>>> getTheMostPeopleTime(){
        int max = getTheMostPeopleInTheRoomByTime();
        Map<String,List<LoungeData>> time =  collectPersonsByTime();
        return time.entrySet()
                .stream()
                .filter(l->l.getValue().size() == max)
                .findFirst();
    }

    public List<LoungeData> getDetailsAboutTheRequestedPerson(int id){
        return data.stream()
                .filter(l->l.id == id)
                .collect(Collectors.toList());
    }

    public List<String> getTheTimeWhenWasTheRequestedPersonInTheLounge(List<LoungeData> reqData){
        List<String> timeList = new ArrayList<>();
        String message = "";
        if(reqData.size() % 2 == 0){
            for(int i = 0; i < reqData.size(); i += 2){
                message = reqData .get(i).hr + ":" + reqData .get(i).min + "-" + reqData .get(i+1).hr + ":" + reqData .get(i+1).min;
                timeList.add(message);
            }
        }else{
            for(int i = 0; i < reqData.size()-1; i += 2){
                message = reqData .get(i).hr + ":" + reqData .get(i).min + "-" + reqData .get(i+1).hr + ":" + reqData .get(i+1).min;
                timeList.add(message);
            }
            message = reqData.get(reqData.size()-1).hr + ":" + reqData.get(reqData.size()-1).min + "-";
            timeList.add(message);
        }
        return timeList;
    }

    private int getTheTimeInMin(int hr, int min){
        return hr * 60 + min;
    }

    public int countTheStayedTime(List<LoungeData> reqData){
        int count = 0;
        if(reqData.size() % 2 == 0){
            for(int i = 0; i < reqData.size(); i += 2){
                count += (getTheTimeInMin(reqData.get(i + 1).hr,reqData.get(i + 1).min) - getTheTimeInMin(reqData.get(i).hr,reqData.get(i).min) );
            }
        }else{
            for(int i = 0; i < reqData.size()-1; i += 2){
                count += (getTheTimeInMin(reqData.get(i + 1).hr,reqData.get(i + 1).min) - getTheTimeInMin(reqData.get(i).hr,reqData.get(i).min) );
            }
            count += getTheTimeInMin(15,0) - getTheTimeInMin(reqData.get(reqData.size()-1).hr,reqData.get(reqData.size()-1).min);
        }
        return count;
    }

    public String getThePersonStatus(List<LoungeData> reqData){
        boolean status = reqData.get(reqData.size()-1).stayedOrNot;

        if(status){
            return "The person stayed in the lounge at the end of the observation.";
        }else{
            return "The person not stayed in the lounge at the end of the observation.";
        }
    }
}
