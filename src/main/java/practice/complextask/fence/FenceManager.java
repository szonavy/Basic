package practice.complextask.fence;

import practice.a_common.MyFileReader;

import java.util.ArrayList;
import java.util.List;

public class FenceManager {
    public static void main(String[] args) {
        String fileIn = "src/main/java/resources/complextasks/fence/kerites.txt";
        MyFileReader reader = new MyFileReader(fileIn);
        List<String> row = reader.readLines();
        List<FenceData> data = new ArrayList<>();

        int oddOrEven;
        int meter;
        String fenceColor;
        for(String r : row){
           String[] cuttingRow = r.split(" ");
           oddOrEven = Integer.parseInt(cuttingRow[0]);
           meter = Integer.parseInt(cuttingRow[1]);
           fenceColor = cuttingRow[2];
           data.add(new FenceData(oddOrEven,meter,fenceColor));
        }
        System.out.println("Task 1:");
        System.out.println(data);

        System.out.println("\nTask 2:");
        System.out.println("There are " + data.size() + "plots have been sold in the street.");

        System.out.println("\nTask 3:");
        FenceData lastHouse = data.get(data.size()-1);
        String eOrO = "";
        if(lastHouse.oddOrEven == 1){
            eOrO = "odd";
        }else{
            eOrO = "even";
        }
        System.out.println("The details about the last house are: There is on the " + eOrO + " side of the street." );
        System.out.println("The house number of the last house is : " + lastHouse.houseNumber);
    }


}
