package practice.mvc.tvseries_1.controller;

import practice.mvc.tvseries_1.dao.GetAllEpizodok;
import practice.mvc.tvseries_1.dao.GetAllSorozatok;
import practice.mvc.tvseries_1.model.Epizod;
import practice.mvc.tvseries_1.model.Sorozatok;

import java.util.List;

public class SeriesController {
    GetAllEpizodok getAllEpizodok = new GetAllEpizodok();
    GetAllSorozatok getAllSorozatok = new GetAllSorozatok();
    List<Epizod> epizodok = getAllEpizodok.getEpizodok();
    List<Sorozatok> sorozatok = getAllSorozatok.getSorozatok();


    public long getAllEpisodeWithDate(){
            return epizodok.stream()
                    .filter(ep -> ep.megjelenes != null)
                    .count();
    }

    public long getAllSorozatok(){
        return sorozatok.stream()
                .count();
        }
}
