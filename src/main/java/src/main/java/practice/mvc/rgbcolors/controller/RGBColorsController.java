package practice.mvc.rgbcolors.controller;

import practice.mvc.rgbcolors.model.RGBColorsData;

import java.util.*;
import java.util.stream.Collectors;

public class RGBColorsController {
    public Map<Integer,List<RGBColorsData>> colors = new HashMap<>();

    public RGBColorsController(List<String> rows) {
        fillTheColorsDetail(rows);
    }
    private void fillTheColorsDetail(List<String> rows){
        for(int j = 0 ; j <rows.size(); j++){
            String[] cuttingRows = rows.get(j).split(" ");
            for(int i = 0; i < cuttingRows.length -2; i+=3){
                colors.computeIfAbsent(j+1, k->new ArrayList<>()).add(new RGBColorsData(Integer.parseInt(cuttingRows[i]),Integer.parseInt(cuttingRows[i+1]),Integer.parseInt(cuttingRows[i+2])));
            }
        }
    }

    public RGBColorsData getTheRequestedColors(int row, int column){
        return colors.get(row).get(column );
    }

    public int countTheLightColors(int pixelColor){
        int pixel = 0;
        int count = 0;
        for(Integer p : colors.keySet()){

            for(int i = 0; i < colors.get(p).size(); i++){
                RGBColorsData oneColor = colors.get(p).get(i);
                pixel = oneColor.red + oneColor.green + oneColor.blue;
                if(pixel > pixelColor){
                    count++;
                }
            }
        }
        return count;
    }
    public int theSmallestColor(){
        return colors.values().stream()
                .flatMap(List::stream)
                .mapToInt(l->l.sum)
                .reduce(10000,Integer::min);
    }
    public Set<RGBColorsData> getTheDarkestPoints(){
        int smallest = theSmallestColor();

        return colors.values().stream()
                .flatMap(List::stream)
                .filter(l->l.sum == smallest)
                .collect(Collectors.toSet());
    }

    public boolean border(int row,int difference){
        for(int i = 0; i < colors.get(row).size()-1; i++){
            if(Math.abs((colors.get(row).get(i).blue - colors.get(row).get(i+1).blue)) > difference){
                return true;
            }
        }
        return false;
    }
    public int firstRowDifferences(int difference){
        int result = 0;
        for(Integer r : colors.keySet()){
            if(border(r,difference)){
                result = r;
                break;
            }
        }
        return result;
    }
    public int lastRowDifferences(int value){
        int result = 0;
        for(int i = colors.size(); i > 0; i--){
            if(border(i,value)){
                result = i;
                break;
            }
        }
        return result;
    }
}
