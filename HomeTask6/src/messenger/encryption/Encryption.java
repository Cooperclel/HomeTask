package messenger.encryption;

import messenger.message.InputTastatur;

public class Encryption {

    public static String keyCreation(){
        String key = null;
        do{
            System.out.println("Создайте ключ для шифрования:");
            key = InputTastatur.inputTastatur();
        }while (key.length()<1);
        System.out.println("Key created");
        return key;
    }

    public static String encryption(String text, String key){
        byte[] byteText = text.getBytes();
        byte[] byteKey = key.getBytes();
        byte[] encryptionText = new byte[text.length()];
        for(int i=0; i < byteText.length; i++){
            encryptionText[i] = (byte) (byteText[i] ^ byteKey[i % byteKey.length]);
        }
        return new String(encryptionText);
    }
}
