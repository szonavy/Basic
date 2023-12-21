package practice.complextask.receptionhr;

import practice.a_common.MyFileReader;

import java.util.ArrayList;
import java.util.List;

public class ReceptionManager {

       public List<TeacherDetails> details = new ArrayList<>();

    public ReceptionManager(List<String> row) {
        fillTheDeatils(row);
    }
    public void fillTheDeatils(List<String> row){
        String lastName;
        String firstName;
        int receptionHr;
        int receptionMin;
        BookingDeatils det;
        int year;
        int month;
        int day;
        int hr;
        int min;


        for(String r : row){
            String[] cuttingRow = r.split(" ");
            lastName = cuttingRow[0];
            firstName = cuttingRow [1];

            String[] cuttingTime = cuttingRow[2].split(":");
            receptionHr = Integer.parseInt(cuttingTime[0]);
            receptionMin = Integer.parseInt(cuttingTime[1]);

            String[] cuttingDateAndHr = cuttingRow[3].split("-");
            String[] cuttingDate = cuttingDateAndHr[0].split("\\.");
            year = Integer.parseInt(cuttingDate[0]);
            month = Integer.parseInt(cuttingDate[1]);
            day = Integer.parseInt(cuttingDate[2]);
            String[] cuttingHr = cuttingDateAndHr[1].split(":");
            hr = Integer.parseInt(cuttingHr[0]);
            min = Integer.parseInt(cuttingHr[1]);

            det = new BookingDeatils(year,month,day,hr,min);
            TeacherDetails tDet = new TeacherDetails(lastName,firstName,receptionHr,receptionMin,det);

            details.add(tDet);
        }

    }

    
}
