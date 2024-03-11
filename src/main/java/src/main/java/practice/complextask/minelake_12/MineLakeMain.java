package practice.complextask.minelake_12;

import practice.a_common.MyFileReader;
import practice.complextask.minelake_12.controller.MineLakeController;

import java.util.ArrayList;
import java.util.List;

public class MineLakeMain {
    static final String FILE_IN = "src/main/java/src/main/resources/resources/complextasks/minelake/melyseg-banya.txt";
    public static void main(String[] args) {
        MyFileReader reader = new MyFileReader(FILE_IN);
        List<String> rows = reader.readLines();
        MineLakeController controller = new MineLakeController(rows);

        System.out.println("\nTask 1:");
        System.out.println(controller.data);

    }
}
