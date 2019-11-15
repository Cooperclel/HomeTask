package bank.saveAndReadFile;

import bank.Bank;
import person.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BankReader {
    public static List<Bank> read(File fileBank){

        List<Bank> bankList = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream(fileBank);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while (true){
                try{
                    bankList.add((Bank) objectInputStream.readObject());
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

        return bankList;
    }
}
