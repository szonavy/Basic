package practice.complextask.minelake_12.solvewithlist.controller;

import practice.complextask.minelake_12.solvewithlist.model.MineLakeCoordinate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MineLakeListController {
    public List<List<Integer>> mineData = new ArrayList<>();

    public MineLakeListController(List<String> rows) {
        fileHandling(rows);
    }
    private  void fileHandling(List<String> rows){

        for (int j = 2; j < rows.size(); j++) {
            List<Integer> lakeRows = new ArrayList<>();
            String[] cutTheRow = rows.get(j).split(" ");

            for(int i = 0 ; i < cutTheRow.length; i++){
                lakeRows.add(Integer.parseInt(cutTheRow[i]));
            }
            mineData.add(lakeRows);
        }
    }

    public int getRequestedDetail(int row, int column){
        return mineData.get(row - 1).get(column - 1);
    }

    public List<Integer> countTheLake(){
        List<Integer> lake = new ArrayList<>();
     for(int j = 0; j < mineData.size(); j++){
         for(int i = 0; i < mineData.get(j).size(); i++){
             if(mineData.get(j).get(i) != 0){
                 lake.add(mineData.get(j).get(i));
             }
         }
     }
     return lake;
    }

    public int getArea(){
        return countTheLake().size();
    }

    public double getAverageDepth(){
        List<Integer> lake = countTheLake();

        return (double)(lake.stream()
                .mapToInt(l-> l)
                .reduce(Integer::sum)).orElse(0) /getArea();
    }

    public int getTheDeepestSize(){
        List<Integer> lake = countTheLake();

        return lake.stream()
                .mapToInt(l->l)
                .reduce(Integer::max).orElse(-1);
    }

    public List<MineLakeCoordinate> getTheDeepestPartCoordinates(){
        List<MineLakeCoordinate> coordinates = new ArrayList<>();
        int deepestSize = getTheDeepestSize();

        for (int j = 0; j < mineData.size(); j++) {
            for(int i = 0; i < mineData.get(j).size(); i++){
                if(mineData.get(j).get(i) == deepestSize){
                    coordinates.add(new MineLakeCoordinate(j + 1,i + 1));
                }
            }
        }
        return coordinates;
    }

    public int getTheLine(){
        int count = 0;

        for (int j = 1; j < mineData.size()-1; j++) {
            for(int i = 1; i < mineData.get(j).size()-1; i++){

                if(mineData.get(j + 1).get(i) == 0 && mineData.get(j).get(i) != 0) {
                    count ++;
                }
                if(mineData.get(j).get(i + 1) == 0 && mineData.get(j).get(i) != 0) {
                    count ++;
                }
                if(mineData.get(j - 1).get(i) == 0 && mineData.get(j).get(i) != 0) {
                    count ++;
                }
                if( mineData.get(j).get(i - 1) == 0 && mineData.get(j).get(i) != 0) {
                    count ++;
                }
            }
        }
        return count;
    }
    public List<StringBuilder> getTheDiagram(int column){
        List<StringBuilder>  diagram = new ArrayList<>();

        for (int j = 0; j < mineData.size(); j++) {
            StringBuilder row = new StringBuilder();
            for (int i = 0; i < mineData.get(j).size(); i++) {
                if(i == column -1) {
                    row = new StringBuilder();
                    if (j < 10) {
                        row.append("0" + (j + 1));
                    } else {
                        row.append(j + 1);
                    }
                    for (int k = 0; k < mineData.get(j).get(column - 1); k++) {
                        row.append("*");
                    }
                }
            }
            diagram.add(row);
        }
        return diagram;
    }
}
