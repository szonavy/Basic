package practice.mvc.rgbcolors.controller;

import practice.mvc.rgbcolors.model.RGBColorsData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RGBColorsController {
    public Map<Integer,List<RGBColorsData>> colors = new HashMap<>();

    public RGBColorsController(List<String> rows) {
        fillTheColorsDetail(rows);
    }
    private void fillTheColorsDetail(List<String> rows){
        for(int j = 0 ; j <rows.size(); j++){
            String[] cuttingRows = rows.get(j).split(" ");
            for(int i = 0; i < cuttingRows.length -2; i+=3){
                colors.computeIfAbsent(j+1, k->new ArrayList<>()).add(new RGBColorsData(j+1,i+1,Integer.parseInt(cuttingRows[i]),Integer.parseInt(cuttingRows[i+1]),Integer.parseInt(cuttingRows[i+2])));
            }
        }
    }

    public RGBColorsData getTheRequestedColors(int row, int column){
        return colors.get(row).get(column );
    }
}
