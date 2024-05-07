package practice.mvc.advertising.controller;

import practice.mvc.advertising.model.Order;

import java.util.ArrayList;
import java.util.List;

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
}
