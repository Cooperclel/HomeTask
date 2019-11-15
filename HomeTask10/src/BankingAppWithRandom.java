import account.Account;
import account.ECurrency;
import bank.Bank;
import bank.BankName;
import person.Person;
import person.PersonName;

import java.math.BigDecimal;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankingAppWithRandom {
    static Random rnd = new Random();
    static List<String> personNames = PersonName.personName();
    static Queue<String> bankNames = BankName.bankName();
    private static int peopleCount = 0;

    //Не готово
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        //int peopleCount = 0;

        List<Bank> banks = Stream.generate(() -> {
            return new Bank(bankNames.poll());
        })
                .limit(bankNames.size())
                .collect(Collectors.toList());

        List<Person> peoples = Stream.generate(() -> {
            peopleCount++;
            return new Person("MP" + rnd.nextInt(), personNames.get(2));
        })
                .limit(100_000)
                .collect(Collectors.toList());

        peoples.parallelStream()
                .filter(e -> rnd.nextBoolean())
                .forEach(e -> {
                    int countCreate = rnd.nextInt(20) + 1;
                    int bankCounter = banks.size();
                    for (int i = 0; i < countCreate; i++) {
                        Bank bank = banks.get(bankCounter);
                        bank.createAccountForPerson(e, new BigDecimal(rnd.nextDouble() * (rnd.nextInt(10_000) + 10)), ECurrency.USD);
                        bankCounter --;
                    }
                });

    }
}
