package Exercise1_2_3;

public class Exercise1_2_3 {
    public static void main(String[] args){
        System.out.println("Через Scanner.in");
        long number1 = InputTastatur.InputTastatur.inputLong();
        ICount c1 = new Count(number1);
        c1.factorial();
        long number2 = InputTastatur.InputTastatur.inputLong();
        ICount c2 = new Count(number2);
        c2.multiplicationRegister();

        System.out.println("Через аргумент");
        int n = Integer.parseInt(args[0]);
        ICount c3 = new Count(n);
        c3.factorial();
        int k = Integer.parseInt(args[1]);
        ICount c4 = new Count(k);
        c4.multiplicationRegister();

    }
}
