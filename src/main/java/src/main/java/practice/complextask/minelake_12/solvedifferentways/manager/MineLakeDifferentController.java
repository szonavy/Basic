package practice.complextask.minelake_12.solvedifferentways.manager;

import practice.complextask.minelake_12.model.MineLakeData;
import practice.complextask.minelake_12.solvedifferentways.model.MineLakeCoordinate;
import practice.complextask.minelake_12.solvedifferentways.model.MineLakeDiagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MineLakeDifferentController {
    public int[][] data;

    public MineLakeDifferentController(List<String> rows) {

        data = new int[Integer.parseInt(rows.get(0))+1][Integer.parseInt(rows.get(1))+1];
        fileHandling(rows);
    }

    private void fileHandling(List<String> rows){

        for(int i = 2; i < rows.size(); i++){
            String[] cutTheRow = rows.get(i).split(" ");

            for(int j = 0; j < cutTheRow.length; j++){
                data[i-2][j] = Integer.parseInt(cutTheRow[j]);
            }
        }
    }
    public int getTheResultByRowAndColumn(int row, int column){
        return data[row-1][column-1];
    }
    public int getTheArea(){
        int area = 0;
       for(int i = 0; i < data.length; i++){
           for(int j = 0; j < data[i].length; j++){
               if(data[i][j] != 0){
                   area++;
               }
           }
       }
       return area;
    }
    public int sumTheDepth(){
        int depth = 0;
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data[i].length; j++){
                    depth += data[i][j];
            }
        }
        return depth;
    }
    public int getTheDeepestPartOfTheLake(){
        int maximum = Integer.MIN_VALUE;
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data[i].length; j++){
                if(maximum < data[i][j]){
                    maximum = data[i][j];
                }
            }
        }
        return maximum;
    }
    public List<MineLakeCoordinate> getTheDeepestCoordinates(){
        int maximum = getTheDeepestPartOfTheLake();
        List<MineLakeCoordinate> deepest = new ArrayList<>();
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data[i].length; j++){
                if(maximum == data[i][j]){
                    deepest.add(new MineLakeCoordinate(i+1,j+1));
                }
            }
        }
        return deepest;
    }
    public int getTheLine(){
        int count = 0;
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data[i].length; j++){
                if(data[i][j] != 0 && data[i-1][j] == 0){
                    count++;
                }
                if(data[i][j] != 0 && data[i][j-1] == 0){
                    count++;
                }
                if(data[i][j] != 0 && data[i][j+1] == 0){
                    count++;
                }
                if(data[i][j] != 0 && data[i+1][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }

    public List<String> getTheDiagram(int column){
        List<String> diagram = new ArrayList<>();
        String row = "";
        String depth = "";

        for(int i = 0; i < data.length; i++){
            if(i < 10){
                row = "0" + (i+1);
            }else{
                row = i + "";
            }
            for(int j = 0; j < data[i][column - 1]; j++){
              depth += "*";
            }
            diagram.add(row+depth);
        }
        return diagram;
    }
}
