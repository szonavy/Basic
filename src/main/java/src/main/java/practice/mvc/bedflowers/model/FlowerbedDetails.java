package practice.mvc.bedflowers.model;

import java.util.Comparator;

public class FlowerbedDetails {
    public int id;
    public int firstBed;
    public int lastBed;
    public String color;
    public int numberOfBeds;
    public boolean bothSide;

    public static  int idCounter = 1;
    public FlowerbedDetails(int firstBed, int lastBed, String color) {
        this.firstBed = firstBed;
        this.lastBed = lastBed;
        this.color = color;
        this.id = idCounter++;

        if(lastBed < firstBed){
            bothSide = true;
          //  numberOfBeds = (allBed - lastBed) +  firstBed;
        }else{
            bothSide = false;
        }
    }


    @Override
    public String toString() {
        return "FlowerbedDetails{" +
                "id=" + id +
                ", firstBed=" + firstBed +
                ", lastBed=" + lastBed +
                ", color='" + color + '\'' +
                ", numberOfBeds=" + numberOfBeds +
                ", bothSide=" + bothSide +
                '}';
    }



}
