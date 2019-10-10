package Exercise1.Exercise1_3;

import java.util.Scanner;

public class InputTastatur {
    public static String inputString(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите какую нибудь строку: ");
        String input = in.nextLine();
        System.out.println("Вы ввели: \n" + input);
        return input;
    }
}
