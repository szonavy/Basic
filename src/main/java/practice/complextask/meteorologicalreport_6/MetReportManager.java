package practice.complextask.meteorologicalreport_6;

import java.util.*;
import java.util.stream.Collectors;

public class MetReportManager {
    List<MetReportData> data = new ArrayList<>();

    public MetReportManager(List<String> row) {
        fileHandling(row);
    }
    void fileHandling(List<String> row){

        for (String r : row) {
            String[] cutTheRow = r.split(" ");


            String time = cutTheRow[1];
            MetReportTime realtime = new MetReportTime(Integer.parseInt(time.substring(0,2)),Integer.parseInt(time.substring(2,4)));

            String windDetail = cutTheRow[2];
            WindDirection direction = new WindDirection(windDetail.substring(0,3),Integer.parseInt(windDetail.substring(3,5)));

            String location = cutTheRow[0];
            int temperature = Integer.parseInt(cutTheRow[3]);


            data.add(new MetReportData(location,realtime,direction,temperature));
        }
    }
    public MetReportTime getLastDataForLocation(String reqLocation){

        int index =  data.stream()
                .filter(l->l.location.equals(reqLocation))
                .sorted(Comparator.comparing(MetReportData::getLocation))
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

    public List<MetReportData> calmWind(String dir, int str){

        return data.stream()
                .filter(l->l.windDetail.direction.equals(dir)  && l.windDetail.strength == str)
                .collect(Collectors.toList());
    }

    public Map<String,Map<Integer,Integer>> averageTemperature(){
        Map<String,Map<Integer,Integer>> average = new HashMap<>();

        for(MetReportData d: data){
            if(d.time.hr == 1 || d.time.hr == 7 || d.time.hr == 13 || d.time.hr == 19) {
                average.computeIfAbsent(d.location,k->new HashMap<>()).put(d.time.hr,d.temperature);//mint egy get
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
                int sum = 0;
                for(Integer t: average.get(a).values()){
                   sum += t;
                }
                averageTemp.put(a,sum/ average.get(a).size()+"");
            }
        }
        return averageTemp ;
    }

    private Map<String,List<MetReportData>> organizeLocationDetails(){
        Map<String,List<MetReportData>> dataByLocation = new HashMap<>();

        for(MetReportData d: data){
           dataByLocation.computeIfAbsent(d.location,k->new ArrayList<>()).add(d);
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
        Map<String, Map<MetReportTime, String>> windMap = new HashMap<>();
        String s;

        for(MetReportData d : data){
            s = "";
            for(int i = 0; i < d.windDetail.strength; i++){
                s += "#";
            }
            windMap.computeIfAbsent(d.location,k->new HashMap<>()).put(d.time,s);
        }
        return windMap;
    }


}
