package exercise3_4;

import java.util.Scanner;

public class InputTastatur {
    public static int inputTastaturInteger() {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        return input;
    }

    public static String inputTastatur() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        return input;
    }
}
