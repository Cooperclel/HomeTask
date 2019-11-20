package bank.saveAndReadFile;

import bank.Bank;

import java.io.*;
import java.util.List;

public class SaveInfoBank implements Serializable {
    public void saveInfoBank (List<Bank> listBank, String fileName){
        File fileBank = new File(fileName);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (int i = 0; i < listBank.size(); i++) {
                objectOutputStream.writeObject(listBank.get(i));
            }
            objectOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
