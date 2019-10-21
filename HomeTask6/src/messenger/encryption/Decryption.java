package messenger.encryption;

import messenger.message.InputTastatur;

public class Decryption {
    public static String keyIndication(){
        String key = null;
        do{
            System.out.println("Введите ключ для расшифрования:");
            key = InputTastatur.inputTastatur();
        }while (key.length()<1);
        System.out.println("Key entered");
        return key;
    }

    public static String decryption(String encryptionText, String key){
        byte[] byteEncryptionText = encryptionText.getBytes();
        byte[] decryptionText = new byte[byteEncryptionText.length];
        byte[] byteKey = key.getBytes();
        for (int i=0; i<byteEncryptionText.length;i++){
            decryptionText[i] = (byte) (byteEncryptionText[i] ^ byteKey[i % byteKey.length]);
        }
        return new String(decryptionText);
    }
}
