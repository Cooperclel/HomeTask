package Exercise1_2_3;

public class Exercise1_2_3 {
    public static void main(String[] args){
        //System.out.println("Число" + args[0]);
        int number1 = InputTastatur.InputTastatur.inputInteger();
        ICount c1 = new Count(number1);
        c1.factorial();
        int number2 = InputTastatur.InputTastatur.inputInteger();
        ICount c2 = new Count(number2);
        c2.multiplicationRegister();

    }
}
