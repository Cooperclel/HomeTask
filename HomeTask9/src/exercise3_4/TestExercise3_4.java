package exercise3_4;

import exercise2.MathRounding;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestExercise3_4 {
    public static void main(String[] args){
        String [] studentsName = {"Illia", "Vanja", "Olja", "Ira", "Kolja", "Sasha", "Sweta"};

        Stream<Person> studentsStream = Stream.generate(() -> {
            int id = (int) Math.random()*10;
            String name = studentsName[(int) Math.random()*10];
            float avgValue = (float) MathRounding.roundingBigDecimal(Math.random()*10, 2);
            return new Person(id, name, avgValue);
        })
                .limit(10000)
                .sorted(new SortedAvgValue())
                .limit(100)
                .sorted(Comparator.comparing(Person::getName));

        Map<Integer, Person> studentsMap = new TreeMap<>(studentsStream.collect(Collectors.toMap(Person::getId, p->p)));

        File studentsFile = new File("studentsFile.txt");

        try{
            FileOutputStream fileOutputStream = new FileOutputStream(studentsFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for(int i=studentsMap.size()-100;i<studentsMap.size();i++){
                objectOutputStream.writeObject(studentsMap.get(i));
            }
            objectOutputStream.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }



    }
}
