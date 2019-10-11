package Exercise2.Exercise2_2;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInput {
    public static String fileInput(String link) throws IOException{
        String text;
        FileInputStream file = new FileInputStream(link);
        System.out.println("Размер файла: " + file.available());
        byte[] byteText = new byte[file.available()];
        file.read(byteText);
        text = new String(byteText);
        return text;
    }
}
