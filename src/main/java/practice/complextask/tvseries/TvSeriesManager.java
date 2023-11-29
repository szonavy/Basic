package practice.complextask.tvseries;

import java.util.ArrayList;
import java.util.List;

public class TvSeriesManager {
    public static void main(String[] args) {
        String fileIn = "src/main/java/resources/complextasks/tvseries/lista-1.txt";

        MyFileReader reader = new MyFileReader(fileIn);
        List<String> rows = reader.readLines();

        List<TvSeriesData> data = new ArrayList<>();
        System.out.println(rows);

        
    }



}
