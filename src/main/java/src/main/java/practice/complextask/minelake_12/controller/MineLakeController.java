package practice.complextask.minelake_12.controller;

import practice.complextask.minelake_12.model.CompareByRow;
import practice.complextask.minelake_12.model.DeepestPartCoordinates;
import practice.complextask.minelake_12.model.LakeDiagram;
import practice.complextask.minelake_12.model.MineLakeData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MineLakeController {
    public List<MineLakeData> data = new ArrayList<>();

    public MineLakeController(List<String> row) {
       fileHandling(row);
    }

    private void fileHandling(List<String> row){
        int lakeRow;
        int lakeColumn;
        int value;
        boolean isLake;

        for(int i = 0; i < row.size(); i++){
            lakeRow = i + 1;
            String[] cutTheRow = row.get(i).split(" ");

            for(int j = 0; j < cutTheRow.length; j++){
                lakeColumn = j + 1;
                value = Integer.parseInt(cutTheRow[j]);
                if(value == 0){
                    isLake = false;
                }else{
                    isLake = true;
                }
                data.add(new MineLakeData(lakeRow,lakeColumn,value,isLake));
            }
        }
    }

    public int getTheRequestedValue(int row, int column){
        return data.stream()
                .filter(l->l.row == row && l.column == column)
                .mapToInt(k->k.value)
                .findFirst()
                .orElse(-1);
    }
    public long getTheArea(){
       return data.stream()
                .filter(l->l.isLake)
                .count();
    }
    public double getTheDepth(){
        return data.stream()
                .filter(l->l.isLake)
                .mapToInt(k->k.value)
                .sum();
    }
    public int getTheDeepestPoint(){
        return data.stream()
                .mapToInt(l->l.value)
                .reduce(0,Integer::max);
    }
    public List<DeepestPartCoordinates> getTheDeepestPartsCoordinates(){
        List<DeepestPartCoordinates> deepestParts = new ArrayList<>();

        int deepest = getTheDeepestPoint();

             data.stream()
                .filter(l->l.value == deepest)
                .forEach(k->deepestParts.add(new DeepestPartCoordinates(k.row,k.column)));

             return deepestParts;
    }

    public int getLakeLine(MineLakeData detail){
        int count = 0;

        for (MineLakeData d : data) {
            if(d.row == detail.row -1 && d.column == detail.column && d.value == 0){
                count++;
            }
            if(d.row == detail.row && d.column == detail.column -1 && d.value == 0){
                count++;
            }
            if(d.row == detail.row + 1 && d.column == detail.column && d.value == 0){
                count++;
            }
            if(d.row == detail.row && d.column == detail.column + 1 && d.value == 0){
                count++;
            }
        }
        return count;
    }

    public int countTheSizeOfLake(){
        int count = 0;

        for(MineLakeData d : data){
            if(d.value != 0){
                count += getLakeLine(d);
            }
        }
        return count;
    }

    public List<LakeDiagram> makeTheDiagram(int column){
        Collections.sort(data,new CompareByRow());
        List<LakeDiagram> diagram = new ArrayList<>();
        String row = "";


        for(MineLakeData d : data){
            String depth = "";
            if(d.column == column){
                if(d.row < 10){
                    row = "0" + d.row + "";
                }else{
                    row = d.row + "";
                }
                for(int i = 0; i < d.value; i++){
                    depth += "*";
                }
                diagram.add(new LakeDiagram(row,depth));
            }
        }
        return diagram;
    }


}
