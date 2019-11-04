package exercise5;

import java.io.*;

public class TestExercise5 {
    public static void main(String[] args) {
        try{
            FileOutputStream fileOutputStream= new FileOutputStream("studentsFile.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
