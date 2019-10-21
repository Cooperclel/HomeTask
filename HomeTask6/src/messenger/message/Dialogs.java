package messenger.message;

import messenger.encryption.Decryption;
import messenger.history.IHistorySaver;
import messenger.message.Message;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Dialogs implements IDialog {
    private Message[] messages = new Message[0];
    private Message message;
    public void addMessages(Message message){
        this.addMessages(new Message[]{message});
    }

    public void addMessages(Message [] messages){
        if (messages != null && messages.length != 0) {
            this.messages = Arrays.copyOf(this.messages, this.messages.length + messages.length);
            int messagesLength = messages.length;
            for (Message mes : messages) {
                this.messages[this.messages.length - messagesLength--] = mes;
            }
        }

    }

    public Message[] getMessages() {
        return messages;
    }

    public String toString() {
        System.out.println("Our dialog: ");
        for (int i=0;i<messages.length;i++){
            System.out.println(i + ") " + messages[i]);
        }
        return "End of dialog";
    }

    public static Dialogs toStringDecryption(Dialogs dialogs) {
        String key = Decryption.keyIndication();
        for (int i = 0; i < dialogs.getMessages().length; i++){
            String decryptionMessage = Decryption.decryption(dialogs.getMessages()[i].getMessage(), key);
            dialogs.getMessages()[i].setMessage(decryptionMessage);
        }
        return dialogs;
    }

    public void history(IHistorySaver saver){
        for (Message message : this.messages) {
            saver.add(message.toString());
        }
    }

    public void sortDialog(){
        Message nullMessage = null;
        for(int i = 0; i<messages.length;i++){
            for (int j =i+1;j<messages.length;j++){
                if(messages[j].getDate().getTime() < messages[i].getDate().getTime()){
                    nullMessage = messages[i];
                    messages[i] = messages[j];
                    messages[j] = nullMessage;
                }
            }
        }
    }
}