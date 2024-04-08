package practice.mvc.tvseries_1;

import practice.mvc.tvseries_1.controller.SeriesController;

public class Main {
    public static void main(String[] args) {
        SeriesController controller = new SeriesController();

        System.out.println("ennyi epizod van " + controller.getAllEpisodeWithDate());
        System.out.println(controller.getAllSorozatok());
    }
}
