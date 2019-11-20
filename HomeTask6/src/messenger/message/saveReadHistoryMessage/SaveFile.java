package messenger.message.saveReadHistoryMessage;

import messenger.message.Dialogs;
import messenger.message.Message;

import java.io.*;
import java.util.List;

public class SaveFile implements Serializable {
    public void saveInfoBank (Dialogs dialogs, String fileName){
        File fileBank = new File(fileName);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(dialogs);
            objectOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
