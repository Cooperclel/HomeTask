package bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BankName implements Serializable {
    public static Queue<String> bankName(){
        Queue<String> bankNames= new ConcurrentLinkedQueue<>(){{
            add("Идея Банк");
            add("Банк БелВЭБ");
            add("Банк Решение");
            add("Банк Дабрабыт");
            add("Абсолютбанк");
            add("Альфа-Банк");
            add("БПС-Сбербанк");
            add("БСБ Банк (БелСвиссБанк)");
            add("БТА Банк");
            add("ВТБ Беларусь");
            add("БелГазпромБанк");
            add("БелАгроПромБанк");
            add("БеларусБанк");
            add("БелИнвестБанк");
            add("Белорусский Банк Малого Бизнеса");
            add("Белорусский Народный Банк");
            add("РРБ-Банк");
            add("ИнтерПэйБанк");
            add("Паритетбанк");
            add("Национальный Банк Республики Беларусь");
            add("ПриорБанк");
            add("МТБанк");
            add("Статусбанк (ЕвроТоргИнвестБанк)");
            add("ФрансаБанк");
            add("ТК Банк");
            add("Хоум Кредит Банк");
            add("ТехноБанк");
            add("ЕвроБанк");
            add("Дельта Банк");
            add("Цептер Банк");
        }};
        return bankNames;
    }
}
