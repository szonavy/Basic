package practice.complextask.tvseries_1;

import java.util.*;

public class TvSeriesManager {
    public static void main(String[] args) {
        String fileIn = "src/main/java/resources/complextasks/tvseries/lista-1.txt";
        String fileOut = "src/main/java/resources/complextasks/tvseries/summa.txt";

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

        day = watchedepisodes / (60*24);
        hr = (watchedepisodes - (day * (60*24))) / 60;
        min = watchedepisodes - ((day * (60*24)) + hr * 60);

        System.out.println("The user spent " + day + " days " +hr + " hours " + min + " minutes with watching the tv series.");

        Scanner sc = new Scanner(System.in);

        System.out.println("Please five me a date as the following format:  yyyy.mm.dd ");
        String givenNumber = sc.next();

        List<TvSeriesData> notSeenSeries = new ArrayList<>();

        String w = givenNumber.replaceAll("\\.","");
        System.out.println(w);
        int r = Integer.parseInt(givenNumber.replaceAll("\\.", ""));
        for(TvSeriesData da : data){
            if(da.watched == 0 && !da.date.equals("NI")) {
                int s = Integer.parseInt(da.date.replaceAll("\\.", ""));
                if(s <= r){
                    notSeenSeries.add(da);
                }
            }
        }
        System.out.println("\nTask 5:");

        for(TvSeriesData d: notSeenSeries){
            System.out.println(d.seasonEpisode + "  " + d.name);
        }

        System.out.println("\nTask 7:");

        System.out.println("Please give me a day of the week: like 'cs'");
        Set<String> seriesOnTheSameDay = new HashSet<>();

        String reqDay = sc.next();

        for(TvSeriesData date: data) {
            if (!date.date.equals("NI")) {
                String[] cutDate = date.date.split("\\.");
                String dw = daysOfTheWeek(Integer.parseInt(cutDate[0]), Integer.parseInt(cutDate[1]), Integer.parseInt(cutDate[2]));

                if (reqDay.equals(dw)) {
                    seriesOnTheSameDay.add(date.name);
                }
            }
        }
        if(seriesOnTheSameDay.isEmpty()){
            System.out.println("There wasn't any tv series on that day.");
        }else{
            System.out.println(seriesOnTheSameDay);
        }

        System.out.println("\nTask 8:");
        MyFileWriter writer = new MyFileWriter(fileOut);
        Map<String,Integer> epsisodeTime = new HashMap<>();
        Map<String,Integer> epsisodeNumber = new HashMap<>();

        for(TvSeriesData da : data){
            if(epsisodeTime.isEmpty()|| !epsisodeTime.containsKey(da.name)){
                epsisodeTime.put(da.name,da.time);
            }else{
                epsisodeTime.put(da.name,epsisodeTime.get(da.name)+da.time);
            }

            if(epsisodeNumber.isEmpty()|| !epsisodeNumber.containsKey(da.name)){
                epsisodeNumber.put(da.name,1);
            }else{
                epsisodeNumber.put(da.name,epsisodeNumber.get(da.name)+1);
            }
        }

        for(String s: epsisodeTime.keySet()){
            System.out.println(s + " " + epsisodeTime.get(s) + " " + epsisodeNumber.get(s));
            writer.writeIntoFile(s + " " + epsisodeTime.get(s) + " " + epsisodeNumber.get(s) + "\n");
        }





    }

    public static String daysOfTheWeek(int y, int m, int d){
        String days[] = {"v","h","k","sze","cs","p","szo"};
        int[] months = {0,3,2,5,0,3,5,1,4,6,2,4};

        if(m < 3) {
            y = y-1;
        }
        String result = days[(y + y / 4 - y /100 + y / 400 + months[m-1] + d) % 7];
        return result;
    }


}
