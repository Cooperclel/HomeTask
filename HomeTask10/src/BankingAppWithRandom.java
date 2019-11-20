import account.Account;
import account.ECurrency;
import bank.Bank;
import bank.BankName;
import bank.SortBanksAvgValue;
import bank.saveAndReadFile.SaveInfoBankWithValidation;
import person.Person;
import person.PersonName;
import person.saveAndReadFile.SaveInfoPersonWithValidation;
import threads.TransferThread;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankingAppWithRandom implements Serializable {
    private static Random rnd = new Random();
    private static List<String> personNames = PersonName.personName();
    private static Queue<String> bankNames = BankName.bankName();
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

        SaveInfoBankWithValidation saveBanks = new SaveInfoBankWithValidation();
        saveBanks.saveInfoBank(banks, "fileBank.txt");

        /*
        * значение имени для каждого созданного Person не будет рандомным, а будет равняться первому знаечнию в personNames
        *  */

        List<Person> peoples = Stream.generate(() -> {
//            peopleCount++;
//            return new Person("MP" + rnd.nextInt(), personNames.get(2));
            return new Person("MP" + rnd.nextInt(), personNames.get(personNames.size() - 1));
        })
                .limit(100_000)
                .collect(Collectors.toList());

        SaveInfoPersonWithValidation savePerson = new SaveInfoPersonWithValidation();
        savePerson.saveInfoPerson(peoples, "filePeople.txt");

        peoples.parallelStream()
                .filter(e -> rnd.nextBoolean())
                .forEach(e -> {
                    int countCreate = rnd.nextInt(20) + 1;
                    for (int i = 0; i < countCreate; i++) {
//                        Bank bank = banks.get(bankCounter);
//                        bank.createAccountForPerson(e, new BigDecimal(rnd.nextDouble() * (rnd.nextInt(10_000) + 10)), ECurrency.USD);
//                        bankCounter --;
                        Bank bank = null;
                        try {
                            bank = banks.get(rnd.nextInt(banks.size()));
                        }catch (IndexOutOfBoundsException exc){}
                        bank.createAccountForPerson(e, new BigDecimal(rnd.nextDouble() * (rnd.nextInt(10_000) + 1)) , ECurrency.USD);
                    }
                });

        System.out.println("Топ 100 банков до начала переводов");
        banks.stream().sorted(new SortBanksAvgValue()).limit(100).forEach(p->{
            System.out.println(p.toString());
        });

        Runnable bankThread = () -> {
            Bank bank1 = banks.get(rnd.nextInt(banks.size())-1);
            Bank bank2 = banks.get(rnd.nextInt(banks.size())-1);

            Map<Person,List<Account>> mapBank1 = bank1.getData();
            Map<Person,List<Account>> mapBank2 = bank2.getData();

            Collection<List<Account>> accountsCollection1 = mapBank1.values();
            Collection<List<Account>> accountsCollection2 = mapBank2.values();

            List<Account> accounts1= accountsCollection1.stream().skip(rnd.nextInt(accountsCollection1.size())).findAny().get();
            List<Account> accounts2= accountsCollection1.stream().skip(rnd.nextInt(accountsCollection2.size())).findAny().get();

            //Метод skip(long n) используется для пропуска n элементов. Этот метод возвращает новый поток, в котором пропущены первые n элементов.
            //Метод findFirst() извлекает из потока первый элемент, а findAny() извлекает случайный объект из потока (нередко так же первый).

            Account account1 = accounts1.get(rnd.nextInt(accounts1.size()));
            Account account2 = accounts2.get(rnd.nextInt(accounts2.size()));

            new TransferThread(account1, account2, bank1, bank2);
        };

        for (int i = 0; i < 100; i++) {
            executorService.execute(bankThread);
            executorService.execute(bankThread);
            executorService.execute(bankThread);
            executorService.execute(bankThread);
            executorService.shutdown();
        }

        System.out.println("Топ 100 банков после переводов");
        banks.stream().sorted(new SortBanksAvgValue()).limit(100).forEach(p->{
            System.out.println(p.toString());
        });
        SaveInfoBankWithValidation newSaveBanks = new SaveInfoBankWithValidation();
        newSaveBanks.saveInfoBank(banks, "newFileBank.txt");

        while (true){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }




    }
}
