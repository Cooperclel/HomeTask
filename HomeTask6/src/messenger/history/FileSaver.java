package messenger.history;

import messenger.history.IHistorySaver;

import java.io.File;
import java.io.PrintStream;

public class FileSaver /*implements IHistorySaver*/ {

    private final File stream;

    public FileSaver(File stream) {
        this.stream = stream;
    }


    public void add(String s) {
        //....
    }
}