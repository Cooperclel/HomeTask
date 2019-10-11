package Exercise1.Exercise1_4;

import Exercise1.Exercise1_3.InputTastatur;

public class StringToLong {

    public static long stringToLong1(){
        System.out.println("Метод с parceLong()");
        String string = InputTastatur.inputString();
        try{
            long newString = Long.parseLong(string.trim()); // trim()  Позволяет удалить пробулы в начале и в конце строки
            System.out.println("Вы получили из строки число типа long: " + newString);
            return newString;
        }catch (NumberFormatException mistake){
            System.out.println("Необходим ввести строку состоящую только из цифр: ");
            return stringToLong1();
        }
    }

    public static long stringToLong2(){
        System.out.println("Метод с valueOf()");
        String string = InputTastatur.inputString();
        try{
            long newString = Long.valueOf(string.trim());
            System.out.println("Вы получили из строки число типа long: " + newString);
            return newString;
        }catch (NumberFormatException mistake){
            System.out.println("Необходим ввести строку состоящую только из цифр: ");
            return stringToLong2();
        }
    }

    public static long stringToLong3(){
        System.out.println("Метод с Long()");
        String string = InputTastatur.inputString();
        try{
            long newString = new Long(string.trim());
            System.out.println("Вы получили из строки число типа long: " + newString);
            return newString;
        }catch (NumberFormatException mistake){
            System.out.println("Необходим ввести строку состоящую только из цифр: ");
            return stringToLong3();
        }
    }
}
