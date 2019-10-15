package messenger.message;

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

    public void history(IHistorySaver saver){
        for (Message message : this.messages) {
            saver.println(message.toString());
        }

    }

    public void fixMessage(){
        if(getMessages().length != 0){
            System.out.println("Выберите номер сообщения, которое хотите исправить:");
            int a = InputTastatur.inputTastaturInteger();
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            long b = date.getTime() - messages[a].getDate().getTime();
            if (date.getTime() - messages[a].getDate().getTime() <= 60000) {
                System.out.println("Исправьте сообщение");
                String newMessage = InputTastatur.inputTastatur();
                messages[a].setMessage(newMessage);
            }else System.out.println("Сообщение не может быть исправлено");
        }else System.out.println("Диалог пуст");
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