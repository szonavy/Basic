package practice.mvc.advertising.model;

public class Order {
    public int day;
    public String town;
    public int orders;

    public Order(int day, String town, int count) {
        this.day = day;
        this.town = town;
        this.orders = count;
    }

    public int getDay() {
        return day;
    }

    public String getTown() {
        return town;
    }

    public int getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "Order{" +
                "day=" + day +
                ", town='" + town + '\'' +
                ", count=" + orders +
                '}';
    }
}
