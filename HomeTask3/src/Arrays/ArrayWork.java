package Arrays;

import Arrays.Objekt.Car.Car;
import Arrays.Objekt.Car.ICar;
import Arrays.Objekt.Car.Models.BMW;
import Arrays.Objekt.Car.Models.Bugati;
import Arrays.Objekt.Car.Models.Masda;
import Arrays.Objekt.Car.Models.Reno;
import Arrays.Objekt.Motor.Motor;
import Arrays.Objekt.Wheel.Wheel;
import InputTastatur.InputTastatur;

public class ArrayWork {
    public static void main(String[] args) {
        /*System.out.println("Необходим размер массива:");
        int k = InputTastatur.inputInteger();
        int a[] = new int [k];
        a = randomArray(k);
        enumerationDoWhile(a);
        enumerationWhile(a);
        enumerationForeach(a);
        enumerationFor(a);
        everySecondElement(a);
        nullStop();*/

        System.out.println("Задание 3");
        ICar car1 = new BMW(new Motor(32,"bens","oho"), new Wheel(12,"Spring","iqwi"));
        ICar car2 = new Reno(new Motor(34,"sol","ohwo"), new Wheel(62,"Winter","iqwiq"));
        ICar car3 = new Bugati(new Motor(37,"bens","oeho"), new Wheel(21,"Summer","iqewi"));
        ICar car4 = new Masda(new Motor(41,"sol","owho"), new Wheel(32,"Spring","iqwiqw"));

        ICar c[] = {car1,car2,car3,car4};
        for(int i = 0;i<c.length;i++){
            System.out.println(i + "-й Объект) " + c[i]);
        }
    }


    public static int[] randomArray(int k){
        System.out.println("Генерация рандомных чисел:");
        int a[] = new int [k];
        for (int i = 0; i<k; i++){
            a[i] = (int)(Math.random()*10+1);
        }
        return a;
    }

    public static void enumerationDoWhile(int []a){
        System.out.println("Перебор по Циклу do while");
        int i = 0;
        int k = a.length;
        do{
            System.out.println(i + "-й Элемент массива = " + a[i]);
            i++;

        }while (i!=k);

    }

    public static void enumerationWhile(int []a){
        System.out.println("Перебор по Циклу while");
        int i = 0;
        int k = a.length;
        while(i<k){
            System.out.println(i + "-й Элемент массива = " + a[i]);
            i++;
        }

    }

    public static void enumerationFor(int []a){
        System.out.println("Перебор по Циклу for");
        for (int i=0;i<a.length;i++){
            System.out.println(i + "-й Элемент массива = " + a[i]);
        }
    }

    public static void enumerationForeach(int []a){
        System.out.println("Перебор по Циклу foreach");
        for (int array:a) {
            System.out.println("Массив: " + array);
        }
    }

    public static void everySecondElement(int a[]){
        System.out.println("Выведем каждый второй элемент:");
        for (int i = 0; i<a.length; i++){
            if(i%2 == 0){
                System.out.println(i + "-й Элемент массива = " + a[i]);
            }
        }

    }

    public static void nullStop(){
        Integer a[] = {12,349,12112, null,12892189, null};
        System.out.println("Проверим элементы массива на null");
        for (int i = 0; i<a.length; i++){
            if (a[i] == null) {
                System.out.println(i + "-й Элемент массива = null");
                break;
            }
            if (i % 2 == 0) {
                System.out.println(i + "-й Элемент массива = " + a[i]);
            }


        }

    }


}
