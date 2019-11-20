package messenger;

import messenger.encryption.Decryption;
import messenger.encryption.Encryption;
import messenger.message.Dialogs;
import messenger.message.saveReadHistoryMessage.ReadFile;

public class ReadDialog {
    public static void main(String [] argc){
        ReadFile readFile = new ReadFile();
        Dialogs dialogs = ReadFile.readDialog("fileDialog.txt");
        String newKey = Decryption.keyIndication();
        Dialogs decryptionDialog = Dialogs.toDecryption(dialogs,newKey);
        System.out.println(decryptionDialog.toString());
        for (int i = 0; i < dialogs.getMessages().length; i++) {
            String encryptionMessage = Encryption.encryption(decryptionDialog.getMessages()[i].getMessage(),newKey);
            dialogs.getMessages()[i].setMessage(encryptionMessage);
        }

    }
}
