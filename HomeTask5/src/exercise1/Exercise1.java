package exercise1;

import java.io.CharArrayReader;
import java.util.Calendar;
import java.util.Date;

public class Exercise1 {
    public static void main(String[] args){
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.DATE,29);
        calendar1.set(Calendar.MONTH,1);
        calendar1.set(Calendar.YEAR,2020);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DATE,12);
        calendar2.set(Calendar.MONTH,10);
        calendar2.set(Calendar.YEAR,2019);

        System.out.println("Введенные даты:\n");
        System.out.println(calendar1.getTime());
        System.out.println(calendar2.getTime());

        System.out.println("\nExercise 1.1:\n");
        System.out.println("Сравнение при помощи equals");
        System.out.println(calendar1.equals(calendar2));
        System.out.println("Сравнение при помощи ==");
        if(calendar1 == calendar2){
            System.out.println(true);
        }else System.out.println(false);

        System.out.println("\nExercise 1.2:\n");
        System.out.println("Было:" + calendar2.getTime());
        calendar2.add(Calendar.MONTH, 1);
        calendar2.add(Calendar.DATE, 5);
        System.out.println("Получили:" +calendar2.getTime());

        System.out.println("\nExercise 1.3:\n");
        System.out.println("Было:" + calendar1.getTime());
        calendar1.roll(Calendar.YEAR,1);
        System.out.println("Получили:" +calendar1.getTime());




    }
}
