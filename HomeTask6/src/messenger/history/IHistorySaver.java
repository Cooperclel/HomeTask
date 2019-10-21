package messenger.history;

public interface IHistorySaver {
    void add(String s);
    void commandList();
    void commandListMessage();
    void commandListDialog();
}