package exercise5;

import exercise3_4.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestExercise5 {
    public static void main(String[] args) {
        List<Person> studensList = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream("studentsFile.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while (true){
                try{
                    studensList.add((Person) objectInputStream.readObject());
                }catch (EOFException e){
                    break;
                }
            }
            fileInputStream.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        studensList.stream().sorted(Comparator.comparing(Person::getId)).forEach(System.out::println);
    }
}
