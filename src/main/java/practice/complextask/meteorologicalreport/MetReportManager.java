package practice.complextask.meteorologicalreport;

import java.util.*;
import java.util.stream.Collectors;

public class MetReportManager {
    List<MetReportData> data = new ArrayList<>();

    public MetReportManager(List<String> row) {
        fileHandling(row);
    }
    void fileHandling(List<String> row){
        String location;
        String time;
        MetReportTime realtime;
        String windDetail;
        WindDirection direction;
        int temperature;

        for (String r : row) {
            String[] cutTheRow = r.split(" ");
            location = cutTheRow[0];
            time = cutTheRow[1];
            realtime = new MetReportTime(Integer.parseInt(time.substring(0,2)),Integer.parseInt(time.substring(2,4)));
            windDetail = cutTheRow[2];
            direction = new WindDirection(windDetail.substring(0,3),Integer.parseInt(windDetail.substring(3,5)));
            temperature = Integer.parseInt(cutTheRow[3]);

            data.add(new MetReportData(location,realtime,direction,temperature));
        }
    }
    public MetReportTime lastDataFromTheRequestedLocation(String reqLocation){
        Collections.sort(data,new CompareByLocation());
        int index =  data.stream()
                .filter(l->l.location.equals(reqLocation))
                .mapToInt(m->data.indexOf(m)).max().getAsInt();

        return data.get(index).time;
    }

    public MetReportData getSmallestTemperature(){
        Collections.sort(data,new CompareByTemperature());

        return data.get(0);
    }

    public MetReportData getHighestTemperature(){
        Collections.sort(data,new CompareByTemperature());

        return data.get(data.size()-1);
    }

    public List<MetReportData> calmWind(){

        return data.stream()
                .filter(l->l.windDetail.direction.equals("000")  && l.windDetail.strength == 0)
                .collect(Collectors.toList());
    }

    public Map<String,Map<Integer,Integer>> averageTemperature(){
        Map<String,Map<Integer,Integer>> average = new HashMap<>();
        Map<Integer,Integer> averageTime = new HashMap<>();

        for(MetReportData d: data){
            if(d.time.hr == 1 || d.time.hr == 7 || d.time.hr == 13 || d.time.hr == 19) {
                averageTime.put(d.time.hr, d.temperature);
                if (average.isEmpty() || !average.containsKey(d.location)) {
                    average.put(d.location, averageTime);
                    averageTime = new HashMap<>();
                } else {
                    Map<Integer, Integer> timeAndTemperature = average.get(d.location);
                    timeAndTemperature.put(d.time.hr, d.temperature);
                    average.put(d.location, timeAndTemperature);
                }
            }
        }
        return average;
    }

    public Map<String,String> getAverageTemperature(){
        Map<String,String> averageTemp = new HashMap<>();
        Map<String,Map<Integer,Integer>> average = averageTemperature();

        for(String a : average.keySet()){
            if(average.get(a).size() < 4){
                averageTemp.put(a,"NA");
            }else{
                int count = 0;
                for(Integer t: average.get(a).values()){
                   count += t;
                }
                averageTemp.put(a,count+"");
            }
        }
        return averageTemp ;
    }

    public Map<String,List<MetReportData>> organizeLocationDetails(){
        Map<String,List<MetReportData>> dataByLocation = new HashMap<>();
        List<MetReportData> separationData = new ArrayList<>();
        for(MetReportData d: data){
            if(dataByLocation.isEmpty() || !dataByLocation.containsKey(d.location)){
                separationData.add(d);
                dataByLocation.put(d.location,separationData);
                separationData = new ArrayList<>();
            }else{
                List<MetReportData> listOfLocation = dataByLocation.get(d.location);
                listOfLocation.add(d);
                dataByLocation.put(d.location,listOfLocation);
            }
        }
        return dataByLocation;
    }

    public Map<String, Integer> temperatureFluctuation(){
        Map<String,List<MetReportData>> organizedLocation = organizeLocationDetails();
        Map<String, Integer> fluctuation = new HashMap<>();

        for(String o : organizedLocation.keySet()){
            List<MetReportData> organizedDetails = organizedLocation.get(o);
            Collections.sort(organizedDetails,new CompareByTemperature());

            int temperatureFlu = organizedDetails.get(organizedDetails.size()-1).temperature - organizedDetails.get(0).temperature;
            fluctuation.put(o,temperatureFlu);
        }
        return fluctuation;
    }






    public Map<String, Map<MetReportTime, String>> showTheWindStrength(){
        Map<MetReportTime, String> strength = new HashMap<>();
        Map<String, Map<MetReportTime, String>> windMap = new HashMap<>();
        String s;
        //Collections.sort(data, new CompareByLocation());

        for(MetReportData d : data){
            s = "";
            for(int i = 0; i < d.windDetail.strength; i++){
                s += "#";
            }
            strength.put(d.time,s);
            if(!windMap.keySet().contains(d.location) || windMap.isEmpty()){
                windMap.put(d.location,strength);
                strength = new HashMap<>();
            }else{
                Map<MetReportTime, String> r = windMap.get(d.location);
                r.put(d.time,s);
                windMap.put(d.location,r);
            }
        }
        return windMap;
    }


}
