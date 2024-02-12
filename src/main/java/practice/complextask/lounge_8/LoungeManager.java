package practice.complextask.lounge_8;

import java.text.Collator;
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

}
