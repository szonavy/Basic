package practice.a_common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {

    public String filePath;

    public MyFileReader(String filePath) {
        this.filePath = filePath;
    }

    public List<String> readLines(){
        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){

            String line = bufferedReader.readLine();

            while(line != null) {
                lines.add(line);
                line = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error while reading from file");
        }

        return lines;
    }
}
