package person.saveAndReadFile;

import person.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonReader {
    public static List<Person> read(File filePerson){

        List<Person> personList = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream(filePerson);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while (true){
                try{
                    personList.add((Person) objectInputStream.readObject());
                }catch (EOFException e){
                    System.out.println("Чтение файла завершено");
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

        return personList;
    }
}
