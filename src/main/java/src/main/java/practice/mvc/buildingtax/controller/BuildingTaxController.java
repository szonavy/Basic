package practice.mvc.buildingtax.controller;

import practice.mvc.buildingtax.model.BuildingTaxDetail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BuildingTaxController {
    public List<BuildingTaxDetail> buildings = new ArrayList<>();
    Map<Character, Integer> tax = new HashMap<>();

    public BuildingTaxController(List<String> rows) {
        fillTheDetails(rows);

    }
    private void fillTheDetails(List<String> rows){
        String[] cuttingFirstLine = rows.get(0).split(" ");
        tax.put('A',Integer.parseInt(cuttingFirstLine[0]));
        tax.put('B',Integer.parseInt(cuttingFirstLine[1]));
        tax.put('C',Integer.parseInt(cuttingFirstLine[2]));

        for(int i = 1; i < rows.size(); i++){
            String[] cutTheRow = rows.get(i).split(" ");
            buildings.add(new BuildingTaxDetail(Integer.parseInt(cutTheRow[0]),cutTheRow[1],cutTheRow[2],cutTheRow[3].charAt(0), Integer.parseInt(cutTheRow[4])));
        }
    }

    public int countTheBuildings(){
        return buildings.size();
    }

    public List<String> getTheRequestedOwnerAddress(int id){
        return buildings.stream()
                .filter(l->l.ownerId == id)
                .map(l->l.street + " street " + l.houseNumber)
                .collect(Collectors.toList());
    }
    private int tax(Character section, int squareFeet){
        int bill = squareFeet * tax.get(section);
            if(bill < 10000){
                bill = 0;
            }
        return bill;
    }
    public Map<Character,Integer> getTheNumberOfOwnerByTax(){
        Map<Character,Integer> bills = new HashMap<>();

        for(BuildingTaxDetail d : buildings){
            int t = tax(d.section,d.square);
            if (!bills.containsKey(d.section)) {
                bills.put(d.section,t);
            }else{
                bills.put(d.section,bills.get(d.section) +t);
            }
        }
        return bills;
    }
    public Map<Character,Integer> getTheNumberSectionByPlot(){
        Map<Character,Integer> number = new HashMap<>();

        for(BuildingTaxDetail d : buildings){

            if (!number.containsKey(d.section)) {
                number.put(d.section,1);
            }else{
                number.put(d.section,number.get(d.section) +1);
            }
        }
        return number;
    }
}
