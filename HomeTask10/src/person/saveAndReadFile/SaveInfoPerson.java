package person.saveAndReadFile;

import bank.Bank;
import person.Person;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SaveInfoPerson {
    public void saveInfoPerson (List<Person> listPerson){
        File filePerson = new File("filePerson");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("fileBank");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (int i = 0; i < listPerson.size(); i++) {
                objectOutputStream.writeObject(listPerson.get(i));
            }
            objectOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
