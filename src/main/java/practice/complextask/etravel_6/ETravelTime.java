package practice.complextask.etravel_6;

public class ETravelTime {
    int year;
    int month;
    int day;
    int hr;
    int min;

    public ETravelTime(int year, int month, int day, int hr, int min) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hr = hr;
        this.min = min;
    }

    public ETravelTime(String time) {

        if(time.length() > 8){
            String[] cuttingTime = time.split("-");
            this.year = Integer.parseInt(cuttingTime[0].substring(0,4));
            this.month = Integer.parseInt(cuttingTime[0].substring(4,6));
            this.day = Integer.parseInt(cuttingTime[0].substring(6,8));
            this.hr = Integer.parseInt(cuttingTime[1].substring(0,2));
            this.min = Integer.parseInt(cuttingTime[1].substring(2,4));
        }else{
            this.year = Integer.parseInt(time.substring(0,4));
            this.month = Integer.parseInt(time.substring(4,6));
            this.day = Integer.parseInt(time.substring(6,8));
            this.hr = -1;
            this.min = -1;
        }



    }


    @Override
    public String toString() {
        return "ETravelTime{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hr=" + hr +
                ", min=" + min +
                '}';
    }
}
