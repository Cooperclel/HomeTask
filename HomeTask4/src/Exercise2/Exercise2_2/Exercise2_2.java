package Exercise2.Exercise2_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Exercise2_2 {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Поиск слов 'война', 'мир', 'и':\n");
        String warAndPeace = FileInput.fileInput("D://Мои документы-Архив вер1//Мои документы//JAVA//Занятие 1//HomeTask2.1//HomeTask4//src//Exercise2//Exercise2_2//Война и мир.txt");
        ITextSearch text = new TextSearch(warAndPeace);
        text.patternWordsSearch();

        System.out.println("\nПоиск слова из аргумента:\n");
        String n = args[0];
        text.patternArgumentSearch(n);

        System.out.println("\nПоиск слова при помощи поиска по строке: \n");
        text.stringSearch();


    }
}
