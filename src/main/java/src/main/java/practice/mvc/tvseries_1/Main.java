package practice.mvc.tvseries_1;

import practice.mvc.tvseries_1.controller.SeriesController;
import practice.mvc.tvseries_1.model.EpisodesAndName;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SeriesController controller = new SeriesController();

        System.out.println("\nTask 2:");
        System.out.println("There are " + controller.getAllEpisodeWithDate() + " episodes with dates");

        System.out.println("\nTask 3:");
        double a = (double) (controller.getSeenSeries() / (double) controller.getNumberOfEpisodes()) * 100.0;
        System.out.println("The user has seen the percent of the series : " + String.format ("%.2f", a) + "%");

        System.out.println("\nTask 4:");
        System.out.println(controller.getInTimeWatchingSeries());

        System.out.println("\nTask 5:");
        List<EpisodesAndName> epName = controller.notSeenEpisodesTillDate(LocalDate.parse("2017-10-18"));
        for (EpisodesAndName n : epName) {
            System.out.println(n.epizodSzam + " " + n.nev);
        }

        System.out.println("\nTask 7:");
        System.out.println(controller.getTheSeriesNameAtRequestedDay("szo"));

        System.out.println("\nTask 8:");
        System.out.println(controller.getTimeAndCountItByName());


    }
}
