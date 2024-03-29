package Exercise1_2_3;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.HashMap;

public class Count implements ICount {
    private long number;

    public Count(long number){
        this.number=number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
    public long getNumber() {
        return number;
    }

    public void factorial(){
        int b = 1;
        for(int i=1; i<=number ; i++){
            b = b * i;
        }
        System.out.println("Факториал числа " + number + " = " + b);
    }

    public void multiplicationRegister(){
        System.out.println("Произведение чисел введенного числа:");
        int b = 1;
        int i = 1;
        long l = number;
        while (number>0){
            System.out.println("Действие " + i + ") ");
            System.out.println(i + "-я Переменная b = " + b);
            b*=number%10;
            System.out.println(i + "-я Переменная number = " + number);
            number = number/10;
            i++;
        }
        System.out.println("Произведение цифр числа " + l + " = " + b);
    }
}
