package practice.complextask.camps_10;

import java.util.*;
import java.util.stream.Collectors;

public class CampManager {

    List<CampDetails> details = new LinkedList<>();


    public CampManager(List<String> rows) {
        fileProcessing(rows);
    }
    private void fileProcessing(List<String> rows){
        int sHr;
        int sMin;
        int eHr;
        int eMin;
        String students;
        String activity;

        for (String r : rows) {
            String[] cutTheRows = r.split("\t");

            sHr = Integer.parseInt(cutTheRows[0]);
            sMin = Integer.parseInt(cutTheRows[1]);
            eHr = Integer.parseInt(cutTheRows[2]);
            eMin = Integer.parseInt(cutTheRows[3]);
            students = cutTheRows[4];
            activity = cutTheRows[5];

            details.add(new CampDetails(new CampDate(sHr,sMin),new CampDate(eHr,eMin),students,activity));

        }
    }

    public int countTheDetails(){
        return details.size();
    }
    public String getTheFirstProgram(){
        return details.get(0).activity;
    }
    public String getTheLastProgram(){
        return details.get(details.size()-1).activity;
    }
    public List<CampDate> getTheStartDatesOfTheMusicCamp(String requestedActivity){
        return details.stream()
                .filter(l->l.activity.equals(requestedActivity))
                .map(k->k.startDate)
                .collect(Collectors.toList());
    }
    private int getTheNumberOfMostInterestedProgram(){
        return details.stream()
                .map(l->l.students.length())
                .reduce(0,Integer::max);
    }
    public List<CampDetails> getTheDetailsOfTheMostInterestedProgram(){
        int nr = getTheNumberOfMostInterestedProgram();
        return details.stream()
                .filter(l->l.students.length() == nr)
                .collect(Collectors.toList());
    }
    private int number(int month, int day){
        int campDay = 0;
        if(month == 6){
            campDay = day =campDay;
        }else if (month == 7){
            campDay = (30 - 16) + day;
        }else if(month == 8){
            campDay = (30 - 16) + 31 + day;
        }
        return campDay;
    }

    public long countTheCampsByTime(int month, int day){
        return details.stream()
                .filter(m->number(m.startDate.month,m.startDate.day) < number(month,day) && number(m.endDate.month,m.endDate.day) > number(month,day))
                .count();
    }
    public List<CampDetails> studentInterests(Character student){
        List<CampDetails> interests = new ArrayList<>();
        for(CampDetails d : details){
            for(int i = 0 ; i < d.students.length(); i++){
                if (d.students.charAt(i) == student) {
                    interests.add(d);
                }
            }
        }
        return interests;
    }
    public String participation(Character student){
        String message = "";
        List<CampDetails> interests = studentInterests(student);
        Collections.sort(interests, new CompareByDate());

        for(int i = 0; i < interests.size()-1; i++){
            for(int j = i+1; j < interests.size(); j++){
                if(interests.get(i+1).startDate.month < interests.get(i).endDate.month || (interests.get(i+1).startDate.month == interests.get(i).endDate.month && interests.get(i+1).startDate.day < interests.get(i).endDate.day)){
                     message = "The student can't go every camp.";
                    break;
                }
            }
        }
        if(message.equals("")){
            message = "The student can go every camp.";
        }
        return message;
    }





}
