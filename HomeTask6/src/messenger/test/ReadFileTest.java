package messenger.test;

import messenger.encryption.Decryption;
import messenger.encryption.Encryption;
import messenger.message.Dialogs;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ReadFileTest {

    @Test
    @ParameterizedTest(name = "{index} -> путь={0}")
    @ValueSource(strings = {"fileDialog.txt","fileDialogsNull.txt","fileNotDialogs.txt","fileWrongName.txt"})
    void readDialog(String fileDialog) {
        System.out.println("Тестирование:");
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
            if(dialogs == null){
                System.out.println("Пустой файл");
            }
            if(dialogs != null){
                Dialogs decryptionDialog = Dialogs.toDecryption(dialogs,"lok");
                System.out.println(decryptionDialog.toString());
                for (int i = 0; i < dialogs.getMessages().length; i++) {
                    String encryptionMessage = Encryption.encryption(decryptionDialog.getMessages()[i].getMessage(),"lok");
                    dialogs.getMessages()[i].setMessage(encryptionMessage);
                }
                System.out.println("\nУспешное тестирование");

            }
        }catch (FileNotFoundException e){
            System.out.println("1)Invalid Test " + e.getMessage());
            //e.printStackTrace();
        }catch (IOException e){
            System.out.println("2)Invalid Test " + e.getMessage());
            //e.printStackTrace();
        }catch (ClassNotFoundException e){
            System.out.println("3)Invalid Test " + e.getMessage());
            //e.printStackTrace();
        }catch (ClassCastException e){
            System.out.println("4)Invalid Test " + e.getMessage());
            //e.printStackTrace();
        }
    }
}