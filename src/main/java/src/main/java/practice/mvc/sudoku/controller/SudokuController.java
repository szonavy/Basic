package practice.mvc.sudoku.controller;

import practice.mvc.sudoku.model.PlayerDecision;

import java.util.ArrayList;
import java.util.List;

public class SudokuController {
    public List<List<Integer>> sudokuTable = new ArrayList<>();
    public List<PlayerDecision> player = new ArrayList<>();

    public SudokuController(List<String> rows) {
        fillTheTable(rows);
    }
    public void fillTheTable(List<String> rows){

        for(int i = 0; i < rows.size(); i++){
            String[] cuttingRows = rows.get(i).split(" ");

            if(cuttingRows.length < 4){
                System.out.println(cuttingRows.length);
                player.add(new PlayerDecision(Integer.parseInt(cuttingRows[0]),Integer.parseInt(cuttingRows[1]),Integer.parseInt(cuttingRows[2])));
            }else{
                List<Integer> r = new ArrayList<>();
                for(String a : cuttingRows){
                    r.add(Integer.parseInt(a));
                }
                sudokuTable.add(r);
            }
        }
    }
    public int getTheValue(int row, int column){
        return sudokuTable.get(row).get(column);
    }

    public int getTheSection(int row, int column){

        if(row >=0 && row <=2 && column >=0 && column <=2){
            return 1;
        }
        if(row >=0 && row <=2 && column >=3 && column <=5){
            return 2;
        }
        if(row >=0 && row <=2 && column >=6 && column <=8){
            return 3;
        }
        if(row >=3 && row <=5 && column >=0 && column <=2){
            return 4;
        }
        if(row >=3 && row <=5 && column >=3 && column <=5){
            return 5;
        }
        if(row >=3 && row <=5 && column >=6 && column <=8){
            return 6;
        }
        if(row >=6 && row <=8 && column >=0 && column <=2){
            return 7;
        }
        if(row >=6 && row <=8 && column >=3 && column <=5){
            return 8;
        }
        if(row >=6 && row <=8 && column >=6 && column <=8){
            return 9;
        }
        return 0;
    }

    public double getTheEmptySpaces(){
        double countTheValues = 0.0;
        double countTheEmptyPlaces = 0.0;

        for(int i = 0; i < sudokuTable.size(); i++){
            for(int j = 0; j < sudokuTable.get(i).size(); j++){
                countTheValues++;
                if(sudokuTable.get(i).get(j) == 0){
                    countTheEmptyPlaces++;
                }
            }
        }
        return ((countTheEmptyPlaces / countTheValues) * 100.0) ;
    }
    public boolean isInTheRowTheValue(int row, int value){
        List<Integer> requestedRow = sudokuTable.get(row);
        for(int i = 0; i < requestedRow.size(); i++){
             if(requestedRow.get(i) == value){
                 return true;
             }
        }
        return false;
    }
    public boolean isInTheColumnTheValue(int column, int value){
        for(int i = 0; i < sudokuTable.size(); i++){
            if(sudokuTable.get(i).get(column) == value){
                return true;
            }
        }
        return false;
    }
    public boolean isInTheSectionTheValue(int section, int value){
        for(int i = 0; i < sudokuTable.size(); i++){
            for(int j = 0; j < sudokuTable.get(i).size(); j++){
                if(getTheSection(i,j) == section && sudokuTable.get(i).get(j) == value){
                    return true;
                }
            }
        }
        return false;
    }
    public List<PlayerDecision> getTheStatus(){
        List<PlayerDecision> playerDecisions = new ArrayList<>();
        for(PlayerDecision p : player){
            int getTheSection = getTheSection(p.row -1,p.column -1);
            if(getTheValue(p.row -1,p.column -1) !=0){
                p.setStatus("The place has already been filled.");
            }else{
                if(isInTheRowTheValue(p.row -1,p.value)){
                    p.setStatus("The value is in the given row.");
                }else{
                    if(isInTheColumnTheValue(p.column -1,p.value)){
                        p.setStatus("The number is already in the given column.");
                    }if(isInTheSectionTheValue(getTheSection,p.value)){
                        p.setStatus("The number is already included in the given sub-table");
                    }else{
                        p.setStatus("The step can be taken.");
                    }
                }
            }
            playerDecisions.add(p);
        }
        return playerDecisions;
    }
}
