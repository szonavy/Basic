package practice.complextask.flowerbeds;

import java.util.*;
import java.util.stream.Collectors;

public class FlowerBeadsController {
    List<FlowerBedsData> data = new ArrayList<>();
    int numberOfFlowers = 0;

    public FlowerBeadsController(List<String> rows) {
        fileHandling(rows);
    }
    private void fileHandling(List<String> rows){
        numberOfFlowers = Integer.parseInt(rows.get(0));
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

    public int countOffersIncludedBed(int bedId){

        return (int) data.stream()
                .filter(l->l.startBedLocation > l.endBedLocation && l.startBedLocation >= bedId && l.endBedLocation >= bedId || l.startBedLocation < l.endBedLocation && l.startBedLocation <= bedId && l.endBedLocation >= bedId)
                .mapToInt(l->l.id)
                .count();
    }

    public String getTheColorOfTheRequestedBedByTheFirstOffer(int bedId){

        return data.stream()
                .filter(l->l.startBedLocation > l.endBedLocation && l.startBedLocation >= bedId && l.endBedLocation >= bedId || l.startBedLocation < l.endBedLocation && l.startBedLocation <= bedId && l.endBedLocation >= bedId)
                .map(k->k.color)
                .findFirst()
                .orElse("This bed is not planted.");
    }

    public Set<String> getTheColorOfTheRequestedBedByAllOffer(int bedId){
        return data.stream()
                .filter(l->l.startBedLocation > l.endBedLocation && l.startBedLocation >= bedId && l.endBedLocation >= bedId || l.startBedLocation < l.endBedLocation && l.startBedLocation <= bedId && l.endBedLocation >= bedId)
                .map(k->k.color)
                .collect(Collectors.toSet());
    }

    private int getTheNumberOfBedsInTheOffers(){
        int count = 0;
        for (FlowerBedsData d : data) {
            if(d.startBedLocation < d.endBedLocation){
                count += d.endBedLocation - d.startBedLocation;
            }else{
                count += numberOfFlowers - d.startBedLocation + d.endBedLocation;
            }
        }
        return count;
    }

    private Set<Integer> generateTheFlowerbeds(){
        Set<Integer> flowerBedsById = new HashSet<>();

        for(int i = 1; i <= numberOfFlowers; i++){
            flowerBedsById.add(i);
        }
        return flowerBedsById;
    }

    private Set<Integer> deleteTheUsedBeds(){
        Set<Integer> flowerBedsById = generateTheFlowerbeds();

        for(FlowerBedsData d : data){
            if(d.startBedLocation < d.endBedLocation){
                for(int i = d.startBedLocation; i <= d.endBedLocation; i++){
                    flowerBedsById.remove(i);
                }
            }else{
                for(int i = d.startBedLocation; i <= numberOfFlowers; i++){
                    flowerBedsById.remove(i);
                }
                for(int i = 1; i <= d.endBedLocation; i++){
                    flowerBedsById.remove(i);
                }
            }
        }
        return flowerBedsById;
    }

    public String isPossibleToPlantAllBeds(){
        String message = "";
        int sizeOfRestBed = deleteTheUsedBeds().size();
        int numberOfAllOffersByBeds = getTheNumberOfBedsInTheOffers();

        if(numberOfAllOffersByBeds > numberOfFlowers && sizeOfRestBed > 0){
            message = "Implantation can be solved by reorganization.";
        }else if(sizeOfRestBed == 0){
            message = "There are applicants for planting every bed.";
        }else if(numberOfAllOffersByBeds < numberOfFlowers){
            message = "The implantation cannot be solved.";
        }
        return message;
    }

    private Map<Integer,Map<String,Integer>> getTheColorOfTheBeds(){
        Map<Integer,Map<String,Integer>> colorBed = new HashMap<>();
        Map<String,Integer> col = new HashMap<>();

        for(FlowerBedsData d : data){
            if(d.startBedLocation < d.endBedLocation){
                for(int i = d.startBedLocation; i <= d.endBedLocation; i++){
                    if(!colorBed.containsKey(i)){
                        col.put(d.color,d.id);
                        colorBed.put(i,col);
                        col = new HashMap<>();
                    }
                }
            }else{
                for(int i = d.startBedLocation; i <= numberOfFlowers; i++){
                    if(!colorBed.containsKey(i)){
                        col.put(d.color,d.id);
                        colorBed.put(i,col);
                        col = new HashMap<>();
                    }
                }
                for(int i = 1; i <= d.endBedLocation; i++){
                    if(!colorBed.containsKey(i)){
                        col.put(d.color,d.id);
                        colorBed.put(i,col);
                        col = new HashMap<>();
                    }
                }
            }
        }
        return colorBed;
    }
    public Map<Integer,Map<String,Integer>> getTheColorOfBedByNoOffers(){
        Map<Integer,Map<String,Integer>> colors = getTheColorOfTheBeds();
        Set<Integer> flowerbeds = generateTheFlowerbeds();
        Map<String,Integer> beds = new HashMap<>();

        for(Integer i : flowerbeds){
            if(!colors.containsKey(i)){
                beds.put("#",0);
                colors.put(i,beds);
            }
        }
        return colors;
    }
}
