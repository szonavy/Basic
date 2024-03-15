package practice.complextask.minelake_12.controller;

import practice.complextask.minelake_12.model.CompareByROwComparator;
import practice.complextask.minelake_12.model.Coordinates;
import practice.complextask.minelake_12.model.MineLakeData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MineLakeController {
    public List<MineLakeData> data = new ArrayList<>();

    public MineLakeController(List<String> rows) {
       fileHandling(rows);
    }

    private void fileHandling(List<String> rows){


        for(int i = 2; i < rows.size(); i++){
            String[] cutTheRow = rows.get(i).split(" ");

            for(int j = 0; j < cutTheRow.length; j++){
                int value = Integer.parseInt(cutTheRow[j]);

                data.add(new MineLakeData(i-1,j + 1, value, value != 0));
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
    public List<MineLakeData> collectTheLake(){
        return data.stream()
                .filter(l->l.isLake)
                .collect(Collectors.toList());
    }

    public long getTheArea(){
       return collectTheLake().size();
    }
    public double getTheDepth(){
        return collectTheLake().stream()
                .mapToInt(k->k.value)
                .sum();
    }

    public int getTheDeepestPoint(){
        return data.stream()
                .mapToInt(l->l.value)
                .reduce(0,Integer::max);
    }
    public List<Coordinates> getTheDeepestPartsCoordinates(){
        List<Coordinates> deepestParts = new ArrayList<>();

        int deepest = getTheDeepestPoint();

             data.stream()
                .filter(l->l.value == deepest)
                .forEach(k->deepestParts.add(new Coordinates(k.row,k.column)));

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

    public List<StringBuilder> makeTheDiagram(int column){
        Collections.sort(data,new CompareByROwComparator());
        List<StringBuilder> diagram = new ArrayList<>();

        for(MineLakeData d : data){
            if(d.column == column){
                StringBuilder row = new StringBuilder();
                if(d.row < 10){
                    row.append("0").append(d.row);
                }else{
                    row.append(d.row);
                }

                for(int i = 0; i < d.value; i++){
                    row.append("*");
                }
                diagram.add(row);
            }
        }
        return diagram;
    }
}
