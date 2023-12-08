package practice.complextask.fence;

import practice.a_common.MyFileReader;

import java.util.List;

public class FenceManager {

    String fileIn = "src/main/java/resources/complextasks/fence/kerites.txt";
    MyFileReader reader = new MyFileReader(fileIn);
    List<String> row = reader.readLines();

    
}
