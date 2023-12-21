package practice.complextask.receptionhr;

import practice.a_common.MyFileReader;

import java.util.List;

public class ReceptionMain {
    public static void main(String[] args) {
        String fileIn = "src/main/java/resources/complextasks/receptionhour/fogado.txt";
        MyFileReader reader = new MyFileReader(fileIn);
        List<String> row = reader.readLines();

        ReceptionManager manager = new ReceptionManager(row);
        System.out.println(manager.details);



    }
}
