package practice.mvc.pits.controller;

import practice.mvc.pits.model.Pit;

import java.util.ArrayList;
import java.util.List;

public class PitController {
    public List<Integer> pits = new ArrayList<>();
    public List<Pit> allPits = new ArrayList<>();
    static final int WIDTH = 10;

    public PitController(List<String> rows) {
        fillTheList(rows);
        findThePits();
    }
    private void fillTheList(List<String> rows){
        for(String s : rows){
            pits.add(Integer.parseInt(s));
        }
    }
    public int getTheNumberOfTheData(){
        return pits.size();
    }
    public int getTheDepthAtTheRequestedLength(int length){
        return pits.get(length -1);
    }
    public double getTheSurface(){
        long zero = pits.stream()
                .filter(l->l == 0)
                .count();

        return ((double)zero / getTheNumberOfTheData()) * 100.0;
    }

    private void findThePits(){
        int pitEnd = 0;
        int volume = 0;
        List<Integer> depth = new ArrayList<>();
        int pitsStart = 0;
        int pitID = 0;
        int startIndex = 0;
        int endIndex = 0;

        for(int i = 1; i < pits.size(); i++){
            int val = pits.get(i);
            if(pits.get(i-1) == 0 && val !=0){
                depth = new ArrayList<>();
                pitsStart = val;
                pitID++;
                volume = 0;
                startIndex = i+1;
            }
            if(val !=0){
                depth.add(val);
                pitEnd = val;
                volume += val * WIDTH;
                endIndex = i+1;

            }
            if(pits.get(i-1) != 0 && val ==0){
                allPits.add(new Pit(pitID,pitsStart,startIndex,endIndex,depth,pitEnd,volume));
            }
        }
    }
    public int getTheNumberOfPit(){
        return allPits.size();
    }

    public Pit getTheRequestedPit(int index){
        if(pits.get(index-1) != 0){
            for(Pit p : allPits){
                if(p.pitsStartIndex <= index && p.pitsEndIndex >= index){
                    return p;
                }
            }
        }
        return null;
    }

    public String getTheStartAndEndIndex(int index){
        Pit p = getTheRequestedPit(index);
        if(p == null){
            return "There is no pit in the place.";
        }else{
            return "The start index " +  p.pitsStartIndex + " and the end index " + p.pitsEndIndex;
        }
    }

    public String gettingDeep(int index){
        Pit p = getTheRequestedPit(index);
        for(int i = 0; i < (p.pitDepths.size()/2) - 1; i++){
            if(p.pitDepths.get(i) > p.pitDepths.get(i+1)){
                return "It does not deepen continuously";
            }
        }
        for(int j = p.pitDepths.size()/2; j < p.pitDepths.size() -1; j++){
            if(p.pitDepths.get(j) < p.pitDepths.get(j+1)){
                return "It does not deepen continuously";
            }
        }
        return "It deepen continuously";
    }
    public int theDeepestPart(int index){
        Pit p = getTheRequestedPit(index);
        return p.pitDepths.stream()
                .reduce(0,Integer::max);
    }

    public int getTheVolume(int index){
        return getTheRequestedPit(index).volume;
    }

    public int getTheTunnel(int index){
        Pit p = getTheRequestedPit(index);
        int t = 0;
        for(int i = 0; i < p.pitDepths.size(); i++){
            t+= (p.pitDepths.get(i) - 1) * WIDTH;
        }
        return t;
    }
}
