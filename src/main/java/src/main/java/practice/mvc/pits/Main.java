package practice.mvc.pits;

import practice.a_common.MyFileReader;
import practice.a_common.MyFileWriter;
import practice.mvc.pits.controller.PitController;
import practice.mvc.pits.model.Pit;

import java.text.DecimalFormat;
import java.util.List;

public class Main {
    private static final String FILE_IN = "src/main/java/src/main/resources/resources/complextasks/pits/melyseg-godrok.txt";
    private static final String FILE_OUT = "src/main/java/src/main/resources/resources/complextasks/pits/pit-depth.txt";

    public static void main(String[] args) {
        MyFileReader reader = new MyFileReader(FILE_IN);
        List<String> rows = reader.readLines();
        PitController controller = new PitController(rows);

        System.out.println("\nTask 1:");
        System.out.println(controller.getTheNumberOfTheData());

        System.out.println("\nTask 2:");
        int length = 9;
        System.out.println(controller.getTheDepthAtTheRequestedLength(length));

        System.out.println("\nTask 3:");
        DecimalFormat format = new DecimalFormat("##.##");
        System.out.println(format.format(controller.getTheSurface()) + "%");

        System.out.println("\nTask 4:");
        System.out.println("The file is exist");
        List<Pit> pits = controller.allPits;
        MyFileWriter writer = new MyFileWriter(FILE_OUT);

        for(Pit p : pits){
            writer.writeIntoFile(p.pitDepths + "\n" );
        }
        System.out.println("\nTask 5:");
        System.out.println(controller.allPits);
        System.out.println(controller.getTheNumberOfPit());

        System.out.println("\nTask 6:");
        System.out.println("a; " + controller.getTheStartAndEndIndex(length));
        System.out.println("b; " + controller.gettingDeep(length));
        System.out.println("c; The deepest part is " + controller.theDeepestPart(length) + "m");
        System.out.println("d; The volume is: " + controller.getTheVolume(length) + "m^3");
        System.out.println("e; " + controller.getTheTunnel(length) + " m^3");

    }
}
