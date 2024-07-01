package practice.mvc.conveyorbelt.controller;

import practice.mvc.conveyorbelt.model.PackageData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConveyorBeltController {
    public List<PackageData> packages = new ArrayList<>();
    public int longOfTheBelt = 0;
    public int generalTime = 0;



    public ConveyorBeltController(List<String> row) {
        fillTheRow(row);
    }
    private void fillTheRow(List<String> row){
        String[] cutTheFirstLine = row.get(0).split(" ");
//TODO: Megkerdezni, hogy hogy lehetne ezt szebben kiszedni? ezzel ment el egy fel ora kb
       longOfTheBelt = Integer.parseInt(cutTheFirstLine[0]);
       generalTime = Integer.parseInt(cutTheFirstLine[1]);
        for(int i = 1; i < row.size(); i++){
            String[] cutTheLine = row.get(i).split(" ");
            packages.add(new PackageData(i,Integer.parseInt(cutTheLine[0]),Integer.parseInt(cutTheLine[1]),Integer.parseInt(cutTheLine[2]),Integer.parseInt(cutTheLine[3])));
        }
    }
    //TODO: sok ido mert nem jol szamozta es kereste meg az  id-t, mire rajottem....
    public int requestedPackageStartPlace(int packageId){
        return packages.get(packageId -1).startPlace;
    }
    public int requestedPackageDestinationPlace(int packageId){
        return packages.get(packageId -1).endPlace;
    }
//TODO: ezt is elszamoltam...de mar nem volt annyi ido megkeresni
    public int distance(int beltLength, int startPlace, int endPlace){
        int dis = 0;
        if(startPlace < endPlace){
            dis = endPlace -startPlace;
        }else{
            dis = (beltLength - startPlace) + endPlace;
        }
        return dis;
    }
    public int getMaxDeliveryLength(){
        return packages.stream()
                .mapToInt(l->distance(longOfTheBelt,l.startPlace,l.endPlace))
                .reduce(-1,Integer::max);
    }
    public List<Integer> getTheIdTheMaxDelivery(){
        int max = getMaxDeliveryLength();
        return packages.stream()
                .filter(l->distance(longOfTheBelt,l.startPlace,l.endPlace) == max)
                .map(l->l.deliveryId)
                .collect(Collectors.toList());
    }
    public int getTheWeightOfPassesByTheRequestedPlace(int place){
        return packages.stream()
                .filter(l->(l.startPlace > l.endPlace && l.startPlace > place && place < l.endPlace) || (l.startPlace < l.endPlace && l.startPlace < place && place < l.endPlace))
                .mapToInt(k->k.weight)
                .reduce(0,Integer::sum);
    }

    public List<Integer> getTheTravelingPackages(int requestedTime){
        return packages.stream()
                .filter(l->l.startTime * generalTime <= requestedTime && requestedTime < l.startTime + (distance(longOfTheBelt,l.startPlace,l.endPlace) * generalTime))
                .map(k->k.deliveryId)
                .collect(Collectors.toList());
    }
    public Map<Integer,Integer> getTheWeightByStartPlace(){
        Map<Integer,Integer> weight = new HashMap<>();

        for (PackageData d : packages) {
            weight.put(d.startPlace,weight.containsKey(d.startPlace) ? weight.get(d.startPlace) + d.weight : d.weight );
        }
        return weight;

    }


}
