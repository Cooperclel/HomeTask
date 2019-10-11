package Exercise2.Exercise2_2;

import javax.swing.border.MatteBorder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextSearch implements ITextSearch{
    private String text;
    public TextSearch(String text){
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }

    public void patternWordsSearch(){
        int and=0;
        int war=0;
        int peace=0;

        //Поиск союза и
        Pattern pattern1 = Pattern.compile("(\\sи\\s)");
        Matcher matcher1 = pattern1.matcher(text);
        while(matcher1.find()) {
            and++;
        }
        System.out.println("Количество союзов 'и' в тексте = " + and);

        //Поиск слове война
        Pattern pattern2 = Pattern.compile("(война)|(Война)");
        Matcher matcher2 = pattern2.matcher(text);
        while(matcher2.find()) {
            war++;
        }
        System.out.println("Количество слов 'война' в тексте = " + war);

        //Поиск слова мир
        Pattern pattern3 = Pattern.compile("(\\sмир\\s)|(Мир\\s)");
        Matcher matcher3 = pattern3.matcher(text);
        while(matcher3.find()) {
            peace++;
        }
        System.out.println("Количество слов 'мир' в тексте = " + peace);
    }

    public void patternArgumentSearch(String arg){
        Pattern pattern = Pattern.compile("\\s"+arg+"\\s");
        Matcher matcher = pattern.matcher(text);
        int word = 0;
        while(matcher.find()) {
            word++;
        }
        System.out.println("Количество слов '" + arg + "' в тексте заданного через аргумент = " + word);
    }

    public void stringSearch(){
        String[] arrayWords = text.split(" +");
        int and=0;
        int war=0;
        int peace=0;

        for (int i = 0; i < arrayWords.length; i++) {
            if (arrayWords[i].equalsIgnoreCase("и")) {
                and++;
            }
        }
        System.out.println("Количество слов 'и' в тексте = " + and);

        for (int i = 0; i < arrayWords.length; i++) {
            if (arrayWords[i].equalsIgnoreCase("война")) {
                war++;
            }
        }
        System.out.println("Количество слов 'война' в тексте = " + war);

        for (int i = 0; i < arrayWords.length; i++) {
            if (arrayWords[i].equalsIgnoreCase("мир")) {
                peace++;
            }
        }
        System.out.println("Количество слов 'мир' в тексте = " + peace);
    }
}
