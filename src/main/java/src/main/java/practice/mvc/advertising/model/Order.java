package practice.mvc.advertising.model;

public class Order {
    int day;
    String town;
    int count;

    public Order(int day, String town, int count) {
        this.day = day;
        this.town = town;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Order{" +
                "day=" + day +
                ", town='" + town + '\'' +
                ", count=" + count +
                '}';
    }
}
