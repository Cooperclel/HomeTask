package messenger.message;


import messenger.encryption.Encryption;
import messenger.user.User;

import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;

public class Message {
    private String message;
    private final User user;
    private Date date;

    public Message(User user) {
        System.out.println("Введите сообщение:");
        message = InputTastatur.inputTastatur();
        this.message = message;
        this.user = user;
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static Message pauseInMessage(Message message){
        System.out.println("Введите количество минут, на которое необходимо задержать сообщение: ");
        int p = InputTastatur.inputTastaturInteger();
        p= p * 60000;
        Date realDate = message.getDate();
        long time = realDate.getTime() + p;
        Date changeDate = new Date(time);
        message.setDate(changeDate);
        return message;
    }

    public static String fixMessage(Dialogs dialogs, String key){
        if(dialogs.getMessages().length != 0){
            System.out.println("Выберите номер сообщения, которое хотите исправить:");
            boolean p =false;
            do{
                try{
                    int a = InputTastatur.inputTastaturInteger();
                    if(a <= dialogs.getMessages().length){
                        Calendar calendar = Calendar.getInstance();
                        Date date = calendar.getTime();
                        long b = date.getTime() - dialogs.getMessages()[a].getDate().getTime();

                        if (date.getTime() - dialogs.getMessages()[a].getDate().getTime() <= 60000) {
                            System.out.println("Исправьте сообщение");
                            String newMessage = InputTastatur.inputTastatur();
                            newMessage = Encryption.encryption(newMessage, key);
                            dialogs.getMessages()[a].setMessage(newMessage);
                        }else System.out.println("Сообщение не может быть исправлено");

                        p = true;
                    }else {
                        System.out.println("Вы введи несуществующий номер сообщения");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Ошибка" + e.getMessage());
                }
            }while(!p);

        }else System.out.println("Диалог пуст");
        return "";
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                " " + user +
                ", date=" + date +
                '}';
    }
}
