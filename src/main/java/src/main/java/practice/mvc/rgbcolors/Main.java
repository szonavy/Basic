package practice.mvc.rgbcolors;

import practice.a_common.MyFileReader;
import practice.mvc.rgbcolors.controller.RGBColorsController;
import practice.mvc.rgbcolors.model.RGBColorsData;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILE_IN = "src/main/java/src/main/resources/resources/complextasks/rgbcolors/kep-1.txt";
    public static void main(String[] args) {
        MyFileReader reader = new MyFileReader(FILE_IN);
        List<String> rows = reader.readLines();
        RGBColorsController controller = new RGBColorsController(rows);

        System.out.println("Task 2:");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please give me the pixels(row and column): ");
        int row = sc.nextInt();
        int column = sc.nextInt();
        RGBColorsData requested = controller.getTheRequestedColors(row,column);
        System.out.println("The colors of the pixel: RBG(" + requested.red + ", " + requested.green + ", " + requested.blue + ")");


    }
}
