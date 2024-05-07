package practice.mvc.advertising.controller;

import practice.mvc.advertising.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AdvertisingManager {

    public List<Order> advertising;

    public AdvertisingManager(List<String> row) {
        advertising = new ArrayList<>();
        fileHandling(row);
    }

    private void fileHandling(List<String> row){
        for (String a : row) {
            String[] cutTheRow = a.split(" ");

            advertising.add(new Order(Integer.parseInt(cutTheRow[0]),cutTheRow[1],Integer.parseInt(cutTheRow[2])));
        }
    }
    public int getTheNumberOfTheCustomers(){
        return advertising.size();
    }

    public int getTheNumberOfTheOrders(){
        return advertising.stream()
                .mapToInt(m->m.orders)
                .reduce(0,Integer::sum);
    }

    public long getTheOrdersByDay(int day){
        return advertising.stream()
                .filter(m->m.day == day)
                .count();
    }

    private Set<Integer> getTheOrdersListByTheOderDay(){
        return advertising.stream()
                .filter(l->l.town.equals("NR"))
                .map(m->m.day)
                .collect(Collectors.toSet());
    }
    public String writeTheNotOrdersDays(){
        String message = "";
        if(getTheOrdersListByTheOderDay().size() == 30){
            message = "There was an order every day from a city not involved in the advertisement";
        }else{
            message = "There weren't any orders on " + (30 - getTheOrdersListByTheOderDay().size()) + " days.";
        }
        return message;
    }
}
