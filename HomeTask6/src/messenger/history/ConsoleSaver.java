package messenger.history;

import messenger.history.IHistorySaver;
import messenger.message.InputTastatur;

import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleSaver implements IHistorySaver {

    private final PrintStream stream;

    public ConsoleSaver(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void add(String s) {
        this.stream.println(s);
    }

    public void commandList(){
        String command1 = "1) Начать переписку";
        String command2 = "2) Завершить переписку";
        this.stream.println("\nСписок операций:\n" + "\n"+ command1 + "\n" + command2 + "\n" + "Введите номер операции");
    }

    public void commandListDialog(){
        String command1 = "1) Произвести шифрованную переписку";
        String command2 = "2) Вывести шифрованный диалог";
        String command3 = "3) Вывести расшифрованный диалог";
        String command4 = "4) Исправить сообщение в диалоге";
        String command5 = "5) Завершить диалог";
        this.stream.println("\nСписок операций:\n" + "\n"+ command1 + "\n" + command2 + "\n" + command3 + "\n" + command4 + "\n" + command5 + "\n" + "Введите номер операции");

    }

    public void commandListMessage(){
        String command1 = "1) Написать сообщение и добавить в диалог";
        String command2 = "2) Написать отложенное сообщение";
        String command3 = "3) Завершить переписку";
        this.stream.println("\nСписок операций:\n" + "\n"+ command1 + "\n" + command2 + "\n" + command3 + "\n" + "Введите номер операции");
    }
    public static String correctCommand(){
        boolean p = false;
        String command = null;
        do{
            command = InputTastatur.inputTastatur();
            Pattern pattern = Pattern.compile("^[0,9]$");
            Matcher matcher = pattern.matcher(command);
            p = matcher.find();
            if(p = false) {
                System.out.println("Invalid Command");
            }
        }while(p = false);
        System.out.println("Correct Command");
        return command;
    }
}