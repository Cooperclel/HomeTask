package messenger;

import messenger.history.ConsoleSaver;
import messenger.history.IHistorySaver;
import messenger.message.Dialogs;
import messenger.message.IDialog;
import messenger.message.Message;
import messenger.user.*;

import java.util.Calendar;
import java.util.Date;

public class Messanger {
    public static void main(String[] args){
        User user1 = ValidateUser.getValidUser();
        user1.toString();
        user1.checkUser(user1);
        Message message1 = new Message(user1);
        Message.pauseInMessage(message1);
        Message message2 = new Message(user1);
        Message message3 = new Message(user1);
        IDialog dialogs = new Dialogs();
        dialogs.addMessages(message1);
        dialogs.addMessages(message2);
        dialogs.addMessages(message3);
        dialogs.sortDialog();
        System.out.println(dialogs.toString());
        dialogs.fixMessage();
        System.out.println(dialogs.toString());

    }
}
