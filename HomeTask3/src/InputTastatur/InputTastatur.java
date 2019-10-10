package InputTastatur;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.math.BigInteger;
import java.util.Scanner;

public class InputTastatur {
    public static long  inputLong(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите какое-нибудь число: ");
        long input = in.nextLong();
        System.out.println("Вы ввели: " + input);
        return input;
    }

    public static int  inputInteger(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите какое-нибудь число: ");
        int input = in.nextInt();
        System.out.println("Вы ввели: " + input);
        return input;
    }

    public static String inputString(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите какое-нибудь строку: ");
        String input = in.nextLine();
        System.out.println("Вы ввели: \n" + input);
        return input;
    }

}
