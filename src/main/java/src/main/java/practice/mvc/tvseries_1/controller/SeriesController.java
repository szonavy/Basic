package practice.mvc.tvseries_1.controller;

import practice.mvc.tvseries_1.dao.GetAllEpizodok;
import practice.mvc.tvseries_1.dao.GetAllSorozatok;
import practice.mvc.tvseries_1.model.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class SeriesController {
    GetAllEpizodok getAllEpizodok = new GetAllEpizodok();
    GetAllSorozatok getAllSorozatok = new GetAllSorozatok();
    List<Epizod> epizodok = getAllEpizodok.getEpizodok();
    Map<Integer,Sorozatok> sorozatok = getAllSorozatok.getSorozatok();


    public long getAllEpisodeWithDate(){
            return epizodok.stream()
                    .filter(ep -> ep.megjelenes != null)
                    .count();
    }

    public long getAllSorozatok(){
        return sorozatok.keySet().stream()
                .count();
    }

    public long getNumberOfEpisodes(){
        return epizodok.size();
    }

    public long getSeenSeries(){
        return epizodok.stream()
                .filter(l->l.megnezett)
                .count();
    }

    private int getTimeWatchingSeriesInMinutes(){
        return epizodok.stream()
                .filter(m->m.megnezett)
                .map(l->sorozatok.get(l.sorozatId).hossz)
                .reduce(0,Integer::sum);
    }

    public Time getInTimeWatchingSeries(){
        return new Time(getTimeWatchingSeriesInMinutes());
    }

    public List<EpisodesAndName> notSeenEpisodesTillDate(LocalDate date){
        List<EpisodesAndName> epName = new ArrayList<>();

        for(Epizod e : epizodok){
            if(e.megjelenes != null && e.megjelenes.isBefore(date) && e.megnezett){
                epName.add(new EpisodesAndName(e.epizodSzam,sorozatok.get(e.sorozatId).nev));
            }
        }
        return epName;
    }
    public String getDaysOfTheWeek(LocalDate date){
        String[] days = {"v","h","k","sze","cs","p","szo"};
        int[] months = {0,3,2,5,0,3,5,1,4,6,2,4};

        if(date.getMonthValue() < 3){
           date.minusYears(1);
        }
        return days[(date.getYear() + date.getYear() / 4 - date.getYear() / 100 + date.getYear() / 400 + months[date.getMonthValue() - 1] + date.getMonthValue()) % 7];
    }
    public Set<String> getTheSeriesNameAtRequestedDay(String nameDay){
        Set<String> sameDaySeries = new HashSet<>();
        for(Epizod e : epizodok){

            if(e.megjelenes != null && getDaysOfTheWeek(e.megjelenes).equals(nameDay)){
                sameDaySeries.add(sorozatok.get(e.sorozatId).nev);
            }
        }
        return sameDaySeries;
    }

    public Map<String, EpisodeTimeAndNumber> getTimeAndCountItByName(){
        Map<String, EpisodeTimeAndNumber> numbers = new HashMap<>();

        for(Epizod e : epizodok){

            for(int r: sorozatok.keySet()){
                if(e.sorozatId == r) {
                    if (!numbers.containsKey(r)) {

                        numbers.put(sorozatok.get(r).nev, new EpisodeTimeAndNumber(sorozatok.get(r).nev, sorozatok.get(r).hossz, 1));
                    } else {

                        EpisodeTimeAndNumber epis = numbers.get(sorozatok.get(r).nev);
                        Sorozatok sor = sorozatok.get(r);
                        numbers.put(epis.name, new EpisodeTimeAndNumber(epis.name, (epis.time + sor.hossz), epis.count++));
                        System.out.println(numbers);
                    }
                }
            }
        }
        return numbers;
    }






}
