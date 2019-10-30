package exercise3_4.History;

import exercise3_4.InputTastatur;

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

    public void commandList(){
        String command1 = "1) Произвести запись в массив";
        String command2 = "2) Записать в коллекцию и отсортировать";
        String command3 = "3) Завершить";
        this.stream.println("\nСписок операций:\n" + "\n"+ command1 + "\n" + command2 + "\n" + command3 + "\n" + "Введите номер операции");
    }

    public void commandListArray(){
        String command1 = "1) Записать число в массив";
        String command2 = "2) Завершить";
        this.stream.println("\nСписок операций:\n" + "\n"+ command1 + "\n" + command2 + "\n" + "Введите номер операции");
    }

}
