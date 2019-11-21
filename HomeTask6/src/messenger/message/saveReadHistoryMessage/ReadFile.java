package messenger.message.saveReadHistoryMessage;

import messenger.message.Dialogs;
import messenger.message.Message;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile implements Serializable{
    public static Dialogs readDialog(String fileDialog){
        Dialogs dialogs = null;
        try{
            FileInputStream fileInputStream = new FileInputStream(fileDialog);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while (true){
                try{
                    dialogs = (Dialogs) objectInputStream.readObject();
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
        }catch (ClassCastException e){
            e.printStackTrace();
        }

        return dialogs;
    }
}
