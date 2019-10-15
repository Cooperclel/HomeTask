package messenger.message;


import messenger.user.User;

import java.util.Calendar;
import java.util.Date;

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
        System.out.println("Введите колечество минут, на которое необходимо задержать сообщение: ");
        int p = InputTastatur.inputTastaturInteger();
        p= p * 60000;
        Date realDate = message.getDate();
        long time = realDate.getTime() + p;
        Date changeDate = new Date(time);
        message.setDate(changeDate);
        return message;
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
