package practice.mvc.sudoku;

import practice.a_common.MyFileReader;
import practice.mvc.sudoku.controller.SudokuController;
import practice.mvc.sudoku.model.PlayerDecision;

import java.text.DecimalFormat;
import java.util.List;

public class Main {
    public static final String FILE_IN = "src/main/java/src/main/resources/resources/complextasks/sudoku/konnyu.txt";

    public static void main(String[] args) {
        MyFileReader reader = new MyFileReader(FILE_IN);
        List<String> rows = reader.readLines();
        SudokuController controller = new SudokuController(rows);

        System.out.println(controller.sudokuTable);
        System.out.println(controller.player);
        System.out.println("Task 1:");
        System.out.println("\nPlease give me the row and the column");
        int row = 1;
        int column = 1;

        System.out.println("\nTask 3:");
        int a = controller.getTheValue(row,column);
        if(a == 0){
            System.out.println("The goven space is still empty");
        }else {
            System.out.println("a; The value is: " + a);
        }
        System.out.println("b; The place is belongs to the " + controller.getTheSection(row,column) + " section.");

        System.out.println("\nTask 4:");
        DecimalFormat format = new DecimalFormat("###.#");
        System.out.println("The average of the empty spaces: " + format.format(controller.getTheEmptySpaces()) + "%");

        System.out.println("\nTask 5:");
        List<PlayerDecision> players = controller.getTheStatus();
        for(PlayerDecision p : players){
            System.out.println("The requested row:" + p.row + " the column: " + p.column + " the number: " + p.value);
            System.out.println(p.status);
        }



    }
}
