package practice.mvc.buildingtax.controller;

import practice.mvc.buildingtax.model.BuildingTaxDetail;

import java.util.ArrayList;
import java.util.List;

public class BuildingTaxController {
    public List<BuildingTaxDetail> buildings = new ArrayList<>();

    public BuildingTaxController(List<String> rows) {
        fillTheDetails(rows);

    }
    private void fillTheDetails(List<String> rows){
        for(int i = 1; i < rows.size(); i++){
            String[] cutTheRow = rows.get(i).split(" ");
            buildings.add(new BuildingTaxDetail(Integer.parseInt(cutTheRow[0]),cutTheRow[1],cutTheRow[2],cutTheRow[3].charAt(0), Integer.parseInt(cutTheRow[4])));
        }
    }
}
