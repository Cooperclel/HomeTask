package Exercise2.Exercise2_1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise2_1 {
    public static void main(String[] args){
        String s = "Я люблю Java";

        /*
        ? - количество символов - один или отсутствует
        + - количество символов - один или больше
        * - количество символов - ноль или больше
         */

        System.out.print("Нормально:\n");
        Pattern pattern1 = Pattern.compile("h*"); //Создаем регулярное выражение где * означает, что мы ищем h в количестве ноль или больше. Следовательно получаем true
        Matcher matcher1 = pattern1.matcher(s);
        Pattern pattern2 = Pattern.compile("h+");// Ищем один или больше, поэтому false, так как буквы h нет
        Matcher matcher2 = pattern2.matcher(s);
        Pattern pattern3 = Pattern.compile("h?");//Ищем один или ноль
        Matcher matcher3 = pattern3.matcher(s);
        System.out.println(matcher1.find());
        System.out.println(matcher2.find());
        System.out.println(matcher3.find());


    }
}
