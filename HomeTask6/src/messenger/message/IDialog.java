package messenger.message;

public interface IDialog {
    void fixMessage();
    void addMessages(Message [] messages);
    void addMessages(Message message);
    void sortDialog();
}
