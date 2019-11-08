package exercise3_4;

import exercise2.MathRounding;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestExercise3_4 {
    private static int id = 0;
    //private static float avgValue = 0;
    public static void main(String[] args){
        String [] studentsName = {"Illia", "Vanja", "Olja", "Ira", "Kolja", "Sasha", "Sweta"};

        Stream<Person> studentsStream = Stream.generate(() -> {
            id++;
            //int id = (int) Math.random()*10;
            String name = studentsName[(int) Math.random()*10];
            float avgValue = (float) MathRounding.roundingBigDecimal(Math.random()*10, 2);
            return new Person(id, name, avgValue);
        })
                .limit(10000)
                .sorted(new SortedAvgValue())
                .limit(100)
                .sorted(Comparator.comparing(Person::getName));

        Map<Integer, Person> studentsMap = new TreeMap<>(studentsStream
                .collect(Collectors.toMap(Person::getId, p->p)));

        List<Person> studentsList = new ArrayList<>();
        studentsMap.entrySet().stream()
                .forEach((p) -> {
            studentsList.add(p.getValue());
        });
        studentsList.stream()
                .sorted(Comparator.comparing(Person::getId))
                .forEach(System.out::println);
//        List<Person> studentsList = new ArrayList<>(studentsMap.entrySet().stream()
//                .collect(Collectors.toList()));
//                //.forEach(System.out::println));
//        for (int i = 0; i < studentsList.size(); i++) {
//            System.out.println(i + ") " + studentsList.get(i));
//        }

        File studentsFile = new File("studentsFile.txt");

        System.out.println(studentsMap);

        try{
            FileOutputStream fileOutputStream = new FileOutputStream(studentsFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for(int i=0;i<studentsList.size();i++){
                objectOutputStream.writeObject(studentsList.get(i));
            }
            objectOutputStream.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }



    }
}
