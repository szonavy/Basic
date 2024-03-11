package practice.complextask.minelake_12.controller;

import practice.complextask.minelake_12.model.MineLakeData;

import java.util.ArrayList;
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

        for(int i = 2; i < row.size(); i++){
            lakeRow = i - 1;
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

    
}
