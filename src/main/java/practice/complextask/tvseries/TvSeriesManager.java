package practice.complextask.tvseries;

import java.util.ArrayList;
import java.util.List;

public class TvSeriesManager {
    public static void main(String[] args) {
        String fileIn = "src/main/java/resources/complextasks/tvseries/lista-1.txt";

        MyFileReader reader = new MyFileReader(fileIn);
        List<String> rows = reader.readLines();

        List<TvSeriesData> data = new ArrayList<>();

        for(int i = 0; i < rows.size()-4; i+=5){
            TvSeriesData d = new TvSeriesData(rows.get(i),rows.get(i+1),rows.get(i+2),Integer.parseInt(rows.get(i+3)),Integer.parseInt(rows.get(i+4)));
            data.add(d);
        }

        System.out.println("Task 1:\n"+data);

        System.out.println("\nTask 2:");

        int count = 0;
        for(TvSeriesData da : data){
            if(!da.date.equals("NI")){
                count++;
            }
        }
        System.out.println("There are " + count + " episodes with air dates in the list.");

        System.out.println("\nTask 3:");

        int seen = 0;
        for(TvSeriesData da : data){
            if(da.watched == 1){
                seen++;
            }
        }
        String format = String.format("%.02f",(float) seen/data.size() * 100.0);
        System.out.println("The user had been seen " + format +  "% of the episodes on the list.");

        System.out.println("\nTask 4:");

        int watchedepisodes = 0;
        for(TvSeriesData da : data){
            if(da.watched == 1){
                watchedepisodes += da.time;
            }
        }

        int day;
        int hr;
        int min;

        



    }



}
