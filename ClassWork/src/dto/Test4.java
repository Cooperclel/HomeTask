package dto;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Test4 {
    public static void main(String []args){
        String pattern_email = "^([80] | [+375])(29)(/*/*/*/*/*/*/*)$";
        Pattern pattern = Pattern.compile(pattern_email);
        String[] telefon = new String[]{
                "+375 29 5553628", "I love you",
                "+375(29)5553628", "80293338092",
                "+375(29)444-99-02", "+7(129)444-99-02"
        };

        for (String tel: telefon
        ) {
            System.out.println(tel);
            Matcher matcher = pattern.matcher(tel);
            System.out.println(matcher.find());

        }
    }
}
