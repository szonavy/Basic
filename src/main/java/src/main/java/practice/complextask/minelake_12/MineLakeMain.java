package practice.complextask.minelake_12;

import practice.a_common.MyFileReader;
import practice.a_common.MyFileWriter;
import practice.complextask.minelake_12.controller.MineLakeController;
import practice.complextask.minelake_12.model.LakeDiagram;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class MineLakeMain {
    static final String FILE_IN = "src/main/java/src/main/resources/resources/complextasks/minelake/melyseg-banya.txt";
    static final String FILE_OUT = "src/main/java/src/main/resources/resources/complextasks/minelake/diagram.txt";

    public static void main(String[] args) {
        MyFileReader reader = new MyFileReader(FILE_IN);
        List<String> rows = reader.readLines();
        MineLakeController controller = new MineLakeController(rows);

        System.out.println("\nTask 1:");
        System.out.println(controller.data);

        System.out.println("\nTask 2:");
        int requestedRow = 12;
        int requestedColumn = 6;
        System.out.println("The measured depth at the given location is " + controller.getTheRequestedValue(requestedRow,requestedColumn) + " dm ");

        System.out.println("\nTask 3:");
        System.out.println("The surface of the lake: " + controller.getTheArea() + " m2");
        DecimalFormat df = new DecimalFormat("#.##");
        double depth = controller.getTheDepth() / controller.getTheArea();
        System.out.println("The standard area: " + df.format(depth) + " m");

        System.out.println("\nTask 4:");
        System.out.println("The deepest part in the lake is: " + controller.getTheDeepestPoint() + " dm");
        System.out.println("The coordinates of deepest part of the lake are : ");
        System.out.println(controller.getTheDeepestPartsCoordinates());

        System.out.println("\nTask 5:");
        System.out.println("The shoreline of the lake is " + controller.countTheSizeOfLake() + " m long");

        System.out.println("\nTask 6:");
        MyFileWriter writer = new MyFileWriter(FILE_OUT);
        System.out.println("Please give me the column id: ");
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        List<LakeDiagram> diagram = controller.makeTheDiagram(row);
        for(LakeDiagram d : diagram){
            writer.writeIntoFile(d.row + d.depth + "\n");
        }

        System.out.println(controller.makeTheDiagram(row));

    }
}
