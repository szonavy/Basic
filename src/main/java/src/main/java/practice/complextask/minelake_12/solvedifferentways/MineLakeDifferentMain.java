package practice.complextask.minelake_12.solvedifferentways;

import practice.a_common.MyFileReader;
import practice.a_common.MyFileWriter;
import practice.complextask.minelake_12.controller.MineLakeController;
import practice.complextask.minelake_12.solvedifferentways.manager.MineLakeDifferentController;
import practice.complextask.minelake_12.solvedifferentways.model.MineLakeDiagram;

import java.text.DecimalFormat;
import java.util.List;

public class MineLakeDifferentMain {

    private static final String FILE_IN = "src/main/java/src/main/resources/resources/complextasks/minelake/melyseg-banya.txt";
    private static final String FILE_OUT = "src/main/java/src/main/resources/resources/complextasks/minelake/diagram2.txt";

    public static void main(String[] args) {
        MyFileReader reader = new MyFileReader(FILE_IN);
        List<String> rows = reader.readLines();
        MineLakeDifferentController controller = new MineLakeDifferentController(rows);

        System.out.println("\nTask 2:");
        int row = 12;
        int column = 6;
        System.out.println("The measured depth at the given location is " + controller.getTheResultByRowAndColumn(row,column) + " dm");

        System.out.println("\nTask 3:");
        System.out.println("The surface of the lake: " + controller.getTheArea() + " m2");
        DecimalFormat df = new DecimalFormat("#.##");
        double depth = (double) controller.sumTheDepth() / controller.getTheArea();
        System.out.println("The standard area: " + df.format(depth) + " m");

        System.out.println("\nTask 4:");
        System.out.println("The deepest part in the lake is: " + controller.getTheDeepestPartOfTheLake());
        System.out.println("The coordinates of deepest part of the lake are : ");
        System.out.println(controller.getTheDeepestCoordinates());

        System.out.println("\nTask 5:");
        System.out.println("The shoreline of the lake is " + controller.getTheLine() + " m long");

        System.out.println("\nTask 6:");
        System.out.println("Please give me an column id:");
        int col = 24;
        List<String> diagram = controller.getTheDiagram(col);
        MyFileWriter writer = new MyFileWriter(FILE_OUT);
        for (String d : diagram) {
            writer.writeIntoFile(d + "\n");
            System.out.println(d + "\n");
        }
    }
}
