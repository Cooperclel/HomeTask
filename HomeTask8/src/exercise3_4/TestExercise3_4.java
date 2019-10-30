package exercise3_4;

import exercise3_4.History.ConsoleSaver;
import exercise3_4.History.IHistorySaver;

import java.io.PrintStream;
import java.util.*;

public class TestExercise3_4 {
    public static void main(String[] args){

        PrintStream console = System.out;
        IHistorySaver consoleList = new ConsoleSaver(console);

        AddNumberArray addNumber = new AddNumberArray();

        String command = null;

        do{
            consoleList.commandList();
            command = ConsoleSaver.correctCommand();
            IHistorySaver consoleListArray = new ConsoleSaver(console);
            String commandArray = null;
            if(command.equals("1")) {
                int wrongInput = 0;
                int correctInput = 0;
                do{
                    consoleListArray.commandListArray();
                    commandArray = ConsoleSaver.correctCommand();
                    if(commandArray.equals("1")){
                        try{
                            System.out.println("Введите число");
                            int number = InputTastatur.inputTastaturInteger();
                            addNumber.addNumbers(number);
                            wrongInput = 0;
                        }catch (InputMismatchException e){
                            if(wrongInput < 2){
                                System.out.println("Ошибка ввода " + e.getMessage());
                                wrongInput++;
                            }
                            else{
                                System.out.println("Количество попыток ввода превысило 3 " + e.getMessage());
                                break;
                            }
                        }
                    }
                }while (!commandArray.equals("2"));
                System.out.println(addNumber.toString());
            }
            List<Integer> listOfNumbers = new ArrayList<>();
            if(command.equals("2")){
                for(int i = 0; i < addNumber.getNumbers().length; i++){
                    listOfNumbers.add(i, addNumber.getNumbers()[i]);
                }
                Collections.sort(listOfNumbers);
                for (int number:listOfNumbers){
                    System.out.println(number);
                }
            }

        }while(!command.equals("3"));

    }
}
