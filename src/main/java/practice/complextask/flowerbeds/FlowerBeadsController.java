package practice.complextask.flowerbeds;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlowerBeadsController {
    List<FlowerBedsData> data = new ArrayList<>();

    public FlowerBeadsController(List<String> rows) {
        fileHandling(rows);
    }
    private void fileHandling(List<String> rows){
        for(int i = 1; i < rows.size(); i++){
            String[] cuttingRows = rows.get(i).split(" ");

            data.add(new FlowerBedsData(Integer.parseInt(cuttingRows[0]),Integer.parseInt(cuttingRows[1]),cuttingRows[2]));
        }
    }
    public int getNumberOfOffers(){
        return data.size();
    }

    public List<Integer> getPlantersIdOnBothSideOfBeds(){
        return data.stream()
                .filter(l->l.startBedLocation > l.endBedLocation)
                .map(m->m.id)
                .collect(Collectors.toList());
    }
}
