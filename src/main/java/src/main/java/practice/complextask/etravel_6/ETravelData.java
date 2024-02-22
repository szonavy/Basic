package practice.complextask.etravel_6;

public class ETravelData {
    int busStopId;
    ETravelTime takeOffTime;
    int cardId;
    String typeOfTicket;
    ETravelTime expirationDate;
    int numberOfTicket;

    public ETravelData(int busStopId, ETravelTime takeOff, int cardId, String typeOfTicket, String ticket) {
        this.busStopId = busStopId;
        this.takeOffTime = takeOff;
        this.cardId = cardId;
        this.typeOfTicket = typeOfTicket;
        if(typeOfTicket.equals("JGY")){
            this.expirationDate = null;
            this.numberOfTicket = Integer.parseInt(ticket);
        }else{
            this.expirationDate = new ETravelTime(ticket);
            this.numberOfTicket = -1;
        }
    }

    @Override
    public String toString() {
        return "ETravelData{" +
                "busStopId=" + busStopId +
                ", takeOff=" + takeOffTime +
                ", cardId=" + cardId +
                ", typeOfTicket='" + typeOfTicket + '\'' +
                ", expirationDate=" + expirationDate +
                ", numberOfTicket=" + numberOfTicket +
                '}';
    }
}
