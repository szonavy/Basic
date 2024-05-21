package practice.mvc.bedflowers.controller;

import practice.mvc.bedflowers.model.Beds;
import practice.mvc.bedflowers.model.CompareById;
import practice.mvc.bedflowers.model.FlowerbedDetails;

import java.util.*;
import java.util.stream.Collectors;

public class FlowerbedManager {
    public List<FlowerbedDetails> detail = new ArrayList<>();
    int allBed = 0;

    public FlowerbedManager(List<String> rows) {
        fileHandling(rows);
    }
    public void fileHandling(List<String> rows){
        allBed = Integer.parseInt(rows.get(0));

        for(int i = 1; i < rows.size(); i++){
            String [] cuttingRows = rows.get(i).split(" ");
            detail.add(new FlowerbedDetails(Integer.parseInt(cuttingRows[0]),Integer.parseInt(cuttingRows[1]),cuttingRows[2]));
        }
    }
    public int getTheNumberOfOffering(){
        return detail.size();
    }
    public List<Integer> getTheBothSideUsers(){
        return detail.stream()
                .filter(l->l.bothSide)
                .map(k->k.id)
                .collect(Collectors.toList());
    }

    public long getTheNumberOfRequestedBed(int bed){
        Collections.sort(detail,new CompareById());

        return detail.stream()
                .filter(l->(l.firstBed <= bed && l.lastBed >= bed ) || (l.firstBed <= bed && l.lastBed <= bed))
                .count();
    }
    public String getTheColorOfRequestedBed(int bed){
     return detail.stream()
             .filter(l->(l.firstBed <= bed && l.lastBed >= bed ) || (l.firstBed <= bed && l.lastBed <= bed))
             .map(k->k.color)
             .findFirst()
             .orElse(null);
    }
    public Set<String> getTheAllColorsOfBed(int bed){
        return detail.stream()
                .filter(l->(l.firstBed <= bed && l.lastBed >= bed ) || (l.firstBed <= bed && l.lastBed <= bed))
                .map(k->k.color)
                .collect(Collectors.toSet());
    }
    public Set<Integer> getTheBeds(){
        Set<Integer> beds = new HashSet<>();

        for(FlowerbedDetails d : detail){
            if(d.firstBed < d.lastBed){
                for(int i = d.firstBed; i <= d.lastBed; i++){
                        beds.add(i);
                }
            }else{
                for(int j = d.firstBed; j <= allBed; j++){
                        beds.add(j);
                }
                for(int z = 1; z <= d.lastBed; z++) {
                        beds.add(z);
                }
            }
        }
        return beds;
    }

    public String getTheOffer(){
        String text = "";
        Set<Integer> beds = getTheBeds();
        int bedCount = 0;

        if(beds.size() == allBed){
            text = "There are applicants for planting every bed.";
        }else {
            for (FlowerbedDetails d : detail) {
                if (d.firstBed < d.lastBed) {
                    bedCount += (d.lastBed - d.firstBed);
                } else {
                    bedCount += (d.firstBed - d.lastBed);
                }
            }
            if(bedCount < allBed){
                text = "The implantation cannot be solved.";
            }else{
                text = "Implantation can be solved by reorganization.";
            }
        }
        return text;
    }

    private Map<Integer, Beds> collectTheColorOfBedsAndUser(){
        Map<Integer, Beds> result = new HashMap<>();

        for(FlowerbedDetails d : detail){
            if (d.firstBed < d.lastBed) {
                for(int i = d.firstBed; i <= d.lastBed; i++){
                    if(!result.containsKey(i)){
                        result.put(i,new Beds(d.color,d.id));
                    }
                }
            }else{
                for(int j = d.firstBed; j <= allBed; j++){
                    if(!result.containsKey(j)){
                        result.put(j,new Beds(d.color,d.id));
                    }
                }
                for(int k = 1; k <= d.lastBed; k++){
                    if(!result.containsKey(k)){
                        result.put(k,new Beds(d.color,d.id));
                    }

                }
            }
        }
        return result;
    }
    public Map<Integer, Beds> getTheResult(){
        Map<Integer, Beds> colors = collectTheColorOfBedsAndUser();
        for(int i = 1; i <= allBed; i++){
            if(!colors.containsKey(i)){
                colors.put(i, new Beds("#",0));
            }
        }
        return colors;
    }
}
