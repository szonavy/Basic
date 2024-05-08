package practice.mvc.camps.controlling;

import practice.mvc.camps.model.CampDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CampControlling {
    public List<CampDetails> details = new ArrayList<>();

    public CampControlling(List<String> rows) {
        fileHandling(rows);
    }
    private void fileHandling(List<String> rows){
        for (String r : rows) {
            String[] cutTheRow = r.split("\t");

            int startMonth = Integer.parseInt(cutTheRow[0]);
            int startDay = Integer.parseInt(cutTheRow[1]);
            int endMonth = Integer.parseInt(cutTheRow[2]);
            int endDay = Integer.parseInt(cutTheRow[3]);
            String students = cutTheRow[4];
            String campName = cutTheRow[5];

            details.add(new CampDetails(startMonth,startDay,endMonth,endDay,students,campName));
        }
    }
    public int getTheNumberOfTheCamps(){
        return details.size();
    }
    public String getTheFirstCampTheme(){
        return details.stream()
                .map(l->l.campName)
                .findFirst()
                .orElse(null);
    }
    public String getTheLastCampTheme(){
        return details.get(details.size()-1).campName;
    }

    public List<CampDetails> getTheRequestedCampDetails(String name){
        return details.stream()
                .filter(l->l.campName.equals(name))
                .collect(Collectors.toList());
    }

    private int getTheMostInterestedStudents(){
        return details.stream()
                .mapToInt(l->l.students.length())
                .reduce(0,Integer::max);
    }

    public List<CampDetails> getTheMostInterestedCampDetails(){
        return details.stream()
                .filter(l->l.students.length() == getTheMostInterestedStudents())
                .collect(Collectors.toList());
    }

}
