package practice.complextask.fence;

import practice.a_common.MyFileReader;

import java.util.*;

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

        System.out.println("\nTask 4:");
        List<FenceData> oddStreet = new ArrayList<>();
        for(int i = 1; i < data.size()-1; i++){
            if(data.get(i).oddOrEven == 1){
                oddStreet.add(data.get(i));
            }
        }
        for(int i = 1; i < oddStreet.size()-1; i++){
            if(oddStreet.get(i-1).fenceColor.equals(oddStreet.get(i).fenceColor) && oddStreet.get(i).fenceColor.equals(oddStreet.get(i+1).fenceColor)){
                System.out.println(data.get(i-1).fenceColor +" " + data.get(i).fenceColor + " " + data.get(i+1).fenceColor + " " + data.get(i).houseNumber);
            }
        }

        System.out.println("\nTask 5:");
        Scanner sc = new Scanner(System.in);
        int requestedHouseNumber = sc.nextInt();
        FenceData neighbour1;
        FenceData neighbour2;
        FenceData owner;

        for(int i = 0; i < data.size(); i++){
            if(data.get(i).houseNumber == requestedHouseNumber){
                neighbour1 = data.get(i-1);
                owner = data.get(i);
                neighbour2 = data.get(i+1);
                System.out.println(wichColour(neighbour1.fenceColor,owner.fenceColor,neighbour2.fenceColor));
            }
        }

        System.out.println("\nTask 6:");
        String up = "";
        String down = "";
        for(FenceData d: data){
            if(d.oddOrEven == 1){
                for(int i = 0; i < d.meter; i++){
                    up += d.fenceColor;
                    if(i == 0){
                        down += d.houseNumber;
                    }else{
                        if(d.houseNumber < 10){
                                down += " ";
                        }
                        if(d.houseNumber > 9 && d.houseNumber < 100){
                            if(i > 1){
                                down += " ";
                            }
                        }
                        if(d.houseNumber > 99){
                            if(i > 2){
                                down += " ";
                            }
                        }
                    }
                }
            }
        }
        System.out.println(up);
        System.out.println(down);
    }

    static String wichColour(String ne1Color, String ownerColor, String n2Color){
        String result = "";

        for(int i = 'A' ; i <= 'Z'; i++){
            String ch = (char)i+"";
            if(!ne1Color.equals(ch) && !ownerColor.equals(ch) && !n2Color.equals(ch)){
                result = (char)i+" ";
                break;
            }
        }
        return result;
    }


}
