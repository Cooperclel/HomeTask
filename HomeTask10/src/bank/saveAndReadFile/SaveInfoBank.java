package bank.saveAndReadFile;

import bank.Bank;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class SaveInfoBank {
    public void saveInfoBank (List<Bank> listBank){
        File fileBank = new File("fileBank");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("fileBank");
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
