package messenger.test;

import messenger.message.Dialogs;
import messenger.message.saveReadHistoryMessage.SaveFile;
import messenger.user.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainCreateFiles {
    public static void main(String[] args){
        // Создаем файл, в который заносим нулевой объект
        Dialogs dialogsNull = null;
        SaveFile saveFileNull = new SaveFile();
        saveFileNull.saveInfoBank(dialogsNull, "fileDialogsNull.txt");

        // Создаем файл хранящий в себе объекты не класса Dialogs
        File fileNotDialogs = new File("fileNotDialogs.txt");
        User SomeUser = new User("Login1", "Passwort1");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileNotDialogs);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(SomeUser);
            objectOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
