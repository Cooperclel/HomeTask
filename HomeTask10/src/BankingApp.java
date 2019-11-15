import account.Account;
import account.ECurrency;
import bank.Bank;
import bank.BankName;
import person.Person;
import person.PersonName;
import threads.TransferThread;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankingApp {

    Random rnd = new Random();
    static List<String> personNames = PersonName.personName();
    static Queue<String> bankNames = BankName.bankName();

    public static void main(String [] args){

        Bank bank1 = new Bank("Идея Банк");
        Bank bank2 = new Bank("Банк БелВЭБ");
        Bank bank3 = new Bank("Банк Решение");

        Person person1 = new Person("MP255_____1", "Илья");
        Person person2 = new Person("MP255_____2", "Игорь");
        Person person3 = new Person("MP255_____3", "Света");
        Person person4 = new Person("MP255_____4", "Валя");
        Person person5 = new Person("MP255_____5", "Григорий");
        Person person6 = new Person("MP255_____6", "Андрей");

        List<Account> accounts1 = person1.getAccounts();
        List<Account> accounts2 = person2.getAccounts();
        List<Account> accounts3 = person3.getAccounts();
        List<Account> accounts4 = person4.getAccounts();
        List<Account> accounts5 = person5.getAccounts();
        List<Account> accounts6 = person6.getAccounts();

        accounts1.add(bank1.createAccountForPerson(person1, new BigDecimal(11_000), ECurrency.BLR));
        accounts1.add(bank3.createAccountForPerson(person1, new BigDecimal(1100), ECurrency.EUR));
        accounts1.add(bank2.createAccountForPerson(person1, new BigDecimal(11_000), ECurrency.USD));

        accounts2.add(bank2.createAccountForPerson(person2, new BigDecimal(10), ECurrency.BTC));
        accounts2.add(bank3.createAccountForPerson(person2, new BigDecimal(1100), ECurrency.EUR));
        accounts2.add(bank1.createAccountForPerson(person2, new BigDecimal(11_000_74), ECurrency.RUB));

        accounts3.add(bank2.createAccountForPerson(person3, new BigDecimal(4_000), ECurrency.EUR));
        accounts3.add(bank3.createAccountForPerson(person3, new BigDecimal(1100), ECurrency.EUR));
        accounts3.add(bank1.createAccountForPerson(person3, new BigDecimal(11_000), ECurrency.USD));

        accounts4.add(bank1.createAccountForPerson(person4, new BigDecimal(11_000), ECurrency.JPY));
        accounts4.add(bank3.createAccountForPerson(person4, new BigDecimal(1100), ECurrency.EUR));
        accounts4.add(bank2.createAccountForPerson(person4, new BigDecimal(17_000), ECurrency.GBP));

        accounts5.add(bank2.createAccountForPerson(person5, new BigDecimal(11_000), ECurrency.BLR));
        accounts5.add(bank3.createAccountForPerson(person5, new BigDecimal(11022223), ECurrency.CNY));
        accounts5.add(bank1.createAccountForPerson(person5, new BigDecimal(66_000), ECurrency.USD));

        accounts6.add(bank2.createAccountForPerson(person6, new BigDecimal(11_000), ECurrency.BLR));
        accounts6.add(bank3.createAccountForPerson(person6, new BigDecimal(1100), ECurrency.EUR));
        accounts6.add(bank1.createAccountForPerson(person6, new BigDecimal(99_000), ECurrency.BLR));



        Account account1 = accounts1.get(0);
        Account account2 = accounts2.get(1);
        Account account3 = accounts3.get(2);
        Account account4 = accounts4.get(0);
        Account account5 = accounts5.get(1);
        Account account6 = accounts6.get(2);

        Thread t1 = new Thread(new TransferThread(account1, account2, bank1));
        Thread t2 = new Thread(new TransferThread(account1, account2, bank2));
        Thread t3 = new Thread(new TransferThread(account1, account2, bank3));
        Thread t4 = new Thread(new TransferThread(account1, account2, bank1));

        t1.start();
        t2.start();
        t3.start();
        t4.start();



    }

}
