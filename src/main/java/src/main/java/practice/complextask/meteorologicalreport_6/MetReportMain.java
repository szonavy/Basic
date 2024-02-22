package practice.complextask.meteorologicalreport_6;

import practice.a_common.MyFileReader;
import practice.a_common.MyFileWriter;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MetReportMain {
    public static void main(String[] args) {
        //staticus valtozoba main fele
        String fileIn = "src/main/java/resources/complextasks/meteorologicalreport/tavirathu13.txt";
        MyFileReader reader = new MyFileReader(fileIn);
        //rows/lines
        List<String> row = reader.readLines();

        MetReportManager manager = new MetReportManager(row);

        System.out.println("\nTask 1:");
        System.out.println(manager.data);

        System.out.println("\nTask 2:");
        System.out.println("Please give me a location");
        Scanner sc = new Scanner(System.in);
        String location = sc.next();
        MetReportTime time = manager.getLastDataForLocation(location);
        //atirni tostringet
        System.out.println("The last report arrived at " + time.hr + ":" + time.sec + " from the " + location + " location");

        System.out.println("\nTask 3:");
        MetReportData smallest = manager.getSmallestTemperature();
        //atirni tostringet
        System.out.println("The smallest temperature details are: " + smallest.location + " " + smallest.time + " " + smallest.temperature + " degree.");
        MetReportData highest = manager.getHighestTemperature();
        System.out.println("The highest temperature details are: " + highest.location + " " + highest.time + " " + highest.temperature + " degree.");

        System.out.println("\nTask 4:");
        String dir = "000";
        int str = 0;
        List<MetReportData> calmWind = manager.calmWind(dir,str);

        if(calmWind.isEmpty()){
            System.out.println("There was no calm wind during the measurements.'");
        }else{
            for(MetReportData r : calmWind){
                System.out.println(r.location + " " + r.time);
            }
        }

        System.out.println("\nTask 5:");

        Map<String,String> average = manager.getAverageTemperature();
        Map<String, Integer> fluctuation = manager.temperatureFluctuation();

        //entryset hasznalata
        for(String a : average.keySet()){
            if(average.get(a).equals("NA")){
                System.out.println(a + " " + average.get(a) + "; temperature fluctuation: " + fluctuation.get(a));
            }else{
                System.out.println(a + " temperature average: " + Integer.parseInt(average.get(a)) + "; temperature fluctuation: " + fluctuation.get(a));
            }
        }

        System.out.println("\nTask 6:");

        Map<String, Map<MetReportTime, String>> strength = manager.showTheWindStrength();
        for(String r : strength.keySet()){
            //filenev konstans valtozoba kiemelni
            MyFileWriter writer = new MyFileWriter("src/main/java/resources/complextasks/meteorologicalreport/" + r + ".txt");

            writer.writeIntoFile(r + "\n");

           for(MetReportTime t : strength.get(r).keySet()){
               //stringbuilderbe vmi 1x kell igy osszeallitani a filet es nem kell mindig megnyitogatni a filet
               writer.writeIntoFile(t + " " + strength.get(r).get(t) + "\n");
           }
        }
        System.out.println("test  " );
    }
}
