package InputTastatur;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.math.BigInteger;
import java.util.Scanner;

public class InputTastatur implements IInputTastatur {
    public static int  inputInteger(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите какое-нибудь число: ");
        int input = in.nextInt();
        System.out.println("Вы ввели: " + input);
        return input;
    }

    public static String inputString(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите какое-нибудь число: ");
        String input = in.next();
        System.out.println("Вы ввели: " + input);
        return input;
    }

}
