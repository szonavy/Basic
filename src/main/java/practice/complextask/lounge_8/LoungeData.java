package practice.complextask.lounge_8;

import java.util.Comparator;

public class LoungeData {
    int hr;
    int min;
    int id;
    String inOut;
    boolean stayedOrNot;
    int numberOfStayedPeople;


    static int number = 0;

    public LoungeData(int hr, int min, int id, String inOut) {
        this.hr = hr;
        this.min = min;
        this.id = id;
        this.inOut = inOut;

        if(inOut.equals("ki")){
            stayedOrNot = false;
            number--;
        }else{
            stayedOrNot = true;
            number++;
        }
        numberOfStayedPeople = number;

    }

    public int getHr() {
        return hr;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInOut() {
        return inOut;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut;
    }

    public boolean isStayedOrNot() {
        return stayedOrNot;
    }

    public void setStayedOrNot(boolean stayedOrNot) {
        this.stayedOrNot = stayedOrNot;
    }

    public int getNumberOfStayedPeople() {
        return numberOfStayedPeople;
    }

    public void setNumberOfStayedPeople(int numberOfStayedPeople) {
        this.numberOfStayedPeople = numberOfStayedPeople;
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        LoungeData.number = number;
    }

    @Override
    public String toString() {
        return "LoungeData{" +
                "hr=" + hr +
                ", min=" + min +
                ", id=" + id +
                ", inOut='" + inOut + '\'' +
                ", stayedOrNot=" + stayedOrNot +
                ", numberOfStayedPeople=" + numberOfStayedPeople +
                '}';
    }





}
