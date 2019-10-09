import Arrays.*;
import  Multiplication_table.*;
import Exercise1_2_3.*;
public class Main {

    public static void main(String[] args) {
        /////////Задание 1/////////////////////////////

        MultiplicationTable multiplicationTable = new MultiplicationTable();
        multiplicationTable.createMultiplicationTable();

        ////////////////////////////////////////////////

        ///////Задание 1.2 и 1.3///////////////////////////////


        //System.out.println("Число" + args[0]);
        int number1 = InputTastatur.InputTastatur.inputInteger();
        ICount c1 = new Count(number1);
        c1.factorial();
        int number2 = InputTastatur.InputTastatur.inputInteger();
        ICount c2 = new Count(number2);
        c2.multiplicationRegister();


        /////////////////////////////////////////////////





    }
}
