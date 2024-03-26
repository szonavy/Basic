package practice.complextask.minelake_12.solvewithlist;

import practice.a_common.MyFileReader;
import practice.a_common.MyFileWriter;
import practice.complextask.minelake_12.solvewithlist.controller.MineLakeListController;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class MineLakeListMain {
    private static final String FILE_IN = "src/main/java/src/main/resources/resources/complextasks/minelake/melyseg-banya.txt";
    private static final String FILE_OUT = "src/main/java/src/main/resources/resources/complextasks/minelake/diagram3.txt";
    public static void main(String[] args) {

        MyFileReader reader = new MyFileReader(FILE_IN);
        List<String> rows = reader.readLines();
        MineLakeListController controller = new MineLakeListController(rows);

        System.out.println("\nTask 1:");
        //System.out.println(controller.mineData);

        System.out.println("\nTask 2:");
        int row = 12;
        int column = 6;
        System.out.println("The measured depth at the given location is " + controller.getRequestedDetail(row,column) + " dm ");

        System.out.println("\nTask 3:");
        System.out.println("The surface of the lake: " + controller.getArea() + " m2");
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("The standard area: " + df.format(controller.getAverageDepth()) + " m");

        System.out.println("\nTask 4:");
        System.out.println("The deepest part in the lake is: " + controller.getTheDeepestSize() + " dm");
        System.out.println(controller.getTheDeepestPartCoordinates());

        System.out.println("\nTask 5:");
        System.out.println("The line of the lake is " + controller.getTheLine() + " m long");

        System.out.println("\nTask 6:");
        Scanner sc = new Scanner(System.in);
        int reqCol = sc.nextInt();
        System.out.println(controller.getTheDiagram(reqCol));
        MyFileWriter writer = new MyFileWriter(FILE_OUT);
        List<StringBuilder> diagram = controller.getTheDiagram(reqCol);
        for(int i = 0; i < diagram.size(); i++){
            writer.writeIntoFile(diagram.get(i) + "\n");
        }

    }
}
