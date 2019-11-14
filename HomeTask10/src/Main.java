import account.Account;
import account.ECurrency;
import account.IAccount;
import bank.Bank;
import bank.BankName;
import bank.IBank;
import bank.TransferCommission;
import person.Person;
import person.PersonName;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static Random rnd = new Random();
    static List<String> personNames = PersonName.personName();
    static Queue<String> bankNames = BankName.bankName();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Bank> banks = Stream.generate(() -> {
            return new Bank(bankNames.poll());
        })
                .limit(bankNames.size())
                .collect(Collectors.toList());

        List<Person> peoples = Stream.generate(() -> {
            return new Person("MP" + rnd.nextInt(), personNames.get(personNames.size() - 1));
        })
                .limit(100_000)
                .collect(Collectors.toList());

        peoples.parallelStream()
                .filter(e -> rnd.nextBoolean())
                .forEach(e -> {
                    int countCreate = rnd.nextInt(20) + 1;
                    for (int i = 0; i < countCreate; i++) {
                        Bank bank = banks.get(rnd.nextInt(banks.size()) - 1);
                        bank.createAccountForPerson(e, new BigDecimal(rnd.nextDouble() * (rnd.nextInt(10_000) + 10)), ECurrency.USD);
                    }
                });



    }
    private static class TransferTread implements Runnable{
        private final Account account1;
        private final Account account2;
        private final Bank bank;
        private Random rnd = new Random();

        private TransferTread(Account account1, Account account2, Bank bank) {
            this.account1 = account1;
            this.account2 = account2;
            this.bank = bank;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                Account acc1 = rnd.nextBoolean() ? account1 : account2;
                Account acc2 = acc1.equals(account1) ? account2 : account1;
                bank.transferInOneBank(acc1, acc2, new BigDecimal(rnd.nextDouble()),bank);
            }
        }
    }
}
