package Exercise1_2_3;

import java.math.BigInteger;
import java.util.HashMap;

public class Count implements ICount {
    private long x;

    public Count(long x){
        this.x=x;
    }

    public void setX(long x) {
        this.x = x;
    }
    public long getX() {
        return x;
    }

    public void factorial(){
        int b = 1;
        for(int i=1; i<=x ; i++){
            b = b * i;
        }
        System.out.println("Факториал числа " + x + " = " + b);
    }



    public void multiplicationRegister(){
        long b = 1;
        int i = 1;
        while (x>0){
            System.out.println("Действие " + i + ") ");
            System.out.println(i + "-я Переменная b = " + b);
            b*=x%10;
            System.out.println(i + "-я Переменная x = " + x);
            x = x/10;
            i++;
        }
        System.out.println("Полученное число: " + b);
    }
}
