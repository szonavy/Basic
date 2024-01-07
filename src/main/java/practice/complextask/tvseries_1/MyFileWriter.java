package practice.complextask.tvseries_1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {

    public String filePath;

    public MyFileWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writeIntoFile(String content){
        createNewFileIfNotExists();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))){

            bufferedWriter.write(content);

        } catch (IOException e) {
            System.out.println("Hiba a file irasa kozben");
        }
    }

    public void createNewFileIfNotExists(){
        try {

            File newFile = new File(filePath);
            newFile.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
