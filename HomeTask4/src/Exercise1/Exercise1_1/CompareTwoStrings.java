package Exercise1.Exercise1_1;

public class CompareTwoStrings {
    public static void main(String args[]) {
        String s1 = "Мама мыла раму";

        String a1 = "Мама";
        String a2 = "мыла";
        String a3 = "раму";
        String s2 = a1 + a2 + a3;

        String s3 = "Мама";
        s3 = s3.concat("мыла");
        s3 = s3.concat("раму"); // concat сумма строки и введенного элемента

        s1 = s1.replace(" ","");
        s2 = s2.replace(" ","");
        s3 = s3.replace(" ","");//replace заменяем пробелы на пустые строки

        System.out.println("Решение для упражнения 1.1");
        boolean p;
        if (s2.equals(s1) == true) {//equals сравнивает последовательность символов в строках
            p = true;
        } else p = false;
        System.out.println("C простым суммированием строк получили: " + p);

        if (s2.equals(s1) == true) {
            p = true;
        } else p = false;
        System.out.println("С concat получили: " + p + "\n");


        System.out.println("Эксперимент:\n");
        System.out.println("Сравнение через intern:");

        if (s1 == s3.intern()) { // intern - проверяет наличие строки в Пуле строк и возвращает ссылку
            p = true;
        } else p = false;
        System.out.println("" + p + "\n");

        int compare1 = s1.compareTo(s2);//cоmpareTo возвращает 0 если содержание текста одиноково
        boolean compare2 = s1.equals(s2);

        System.out.println("Сравнение через compareTo:");
        if (compare1 == 0){
            System.out.println(true);
        } else System.out.println(false);
        System.out.println("Значение compare1 = " + compare1 + "\n");

        System.out.println("Сравнение через equals:");
        if (compare2 == true){
            System.out.println(compare2);
        } else System.out.println(compare2);
        System.out.println("Значение compare2 = " + compare2 + "\n");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
