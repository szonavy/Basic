package practice.mvc.advertising;

import practice.a_common.MyFileReader;
import practice.mvc.advertising.controller.AdvertisingManager;

import java.util.List;

public class Main {
    private static final String FILE_IN = "src/main/java/src/main/resources/resources/advertising/rendel.txt";

    public static void main(String[] args) {
        MyFileReader reader = new MyFileReader(FILE_IN);
        List<String> row = reader.readLines();
        AdvertisingManager manager = new AdvertisingManager(row);

        System.out.println("Task 1:");
        System.out.println(manager.advertising);

        System.out.println("\nTask 2:");
        System.out.println("The number of the customers : " + manager.getTheNumberOfTheCustomers());
        System.out.println("The number of the orders are : " + manager.getTheNumberOfTheOrders());

        System.out.println("\nTask 3:");
        int day = 9;
        System.out.println("The number of the orders by " + day + ".day: " + manager.getTheOrdersByDay(day));

        System.out.println("\nTask 4:");
        System.out.println(manager.writeTheNotOrdersDays());

        System.out.println("\nTask 5:");
        System.out.println("The biggest orders number was: " + manager.getTheBiggestOrdersNumber());
        System.out.println("The day of the order was : " + manager.getTheDayOfTheBiggestOrderingNumber());

        System.out.println("\nTask 7:");
        int d = 21;
        System.out.println("The number of products ordered on the day : " + d);
        System.out.println(manager.summarizeTheOrdersByDay(21));

    }





}
