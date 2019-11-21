package bank;

import account.Account;
import account.ECurrency;
import account.IAccount;
import com.sun.jdi.Value;
import person.Person;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Bank implements IBank, Serializable {
    private final String name;
    private Map<Person, List<Account>> data = new HashMap<>();
    private BigDecimal bankBalance;

    public Bank(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBankBalance() {
        return bankBalance;
    }

    public Map<Person, List<Account>> getData() {
        return data;
    }

    public void setData(Map<Person, List<Account>> data) {
        this.data = data;
    }

    public void setBankBalance(BigDecimal bankBalance) {
        this.bankBalance = bankBalance;
    }

    public BigDecimal sumAccountsMoneyInBank(){
        BigDecimal bankAccountMoney = new BigDecimal(0);
        for(List<Account> listAccounts:data.values()){
            for (Account account:listAccounts){
                bankAccountMoney = bankAccountMoney.add(account.getBalance());
            }
        }
        return bankAccountMoney;
    }

    public void addBankBalance(BigDecimal money){
        try{
            getBankBalance().add(money);
            setBankBalance(bankBalance);
        }catch (NullPointerException e){}

    }

    public void addClient(Person p) throws IllegalArgumentException{
        if(!data.containsKey(p)){
            data.put(p, new ArrayList<>());
        } else {
            throw new IllegalArgumentException("Клиент уже имеет счета в банке");
        }
    }

    public void delClient(Person p) throws IllegalStateException{
        if(!data.containsKey(p)){
            throw new IllegalArgumentException(String.format("Данный человек не имеет счетов в банке %s", this.name));
        } else {
            //Проверка: нельзя удалить клиента пока у него есть деньги на счету
            BigDecimal balance = new BigDecimal(0);
            for(Account account:p.getAccounts()){
                account.transferFromCurrencyToDollar();
                balance = account.getBalance();
            }
            if(balance.doubleValue()>0){
                System.out.println("Клиент " + p.getName() + "имеет средства на счету.\n Общая сумма средств в долларах: " + balance
                        + "\nПока средства не будут сняты со счета, счет не может быть удален");
            }
            else {
                data.remove(p);
                System.out.println("Клиент "+ p.getName()+" успешно удален");
            }
        }
    }

    public Account createAccountForPerson(Person p, BigDecimal startAmount, ECurrency eCurrency){
        Account account = null;
        try{
            account = new Account(UUID.randomUUID().toString(), startAmount, eCurrency);
            addAccount(p, account);
        }catch (NullPointerException e){}

        return account;
    }

    private void addAccount(Person p, Account account) throws IllegalArgumentException{
        try {
            this.addClient(p);
        } catch (IllegalArgumentException ignored){
            //System.out.println("У пользователя уже есть учетка");
        }
        //Проверка, что счета с таким номером в банке нет
        List<Account> accounts = this.data.get(p);
        int counter=0;
        try{
            for (int i = 0; i < accounts.size(); i++) {
                if(account.getId().equals(accounts.get(i))){
                    System.out.println("Счет с id: " + account.getId() + "уже есть в банке");
                }
            }
            if(counter == 0){
                accounts.add(account);
            }
            else {
                System.out.println("Счет с id: " + account.getId() + "уже есть в банке");
            }

        }catch (NullPointerException e){}


    }

    public void transferInOneBank(final Account from, final Account to, BigDecimal sum, Bank bank){

        synchronized (from){
            synchronized (to){
                if(from == null || to == null){
                    System.out.println("Аккаунт отправитель или аккаунт получатель не найдены");
                }
                if(from.getBalance().compareTo(sum) == 1){
                    from.withdraw(sum);
                    BigDecimal newSumTo = Account.transferSumToDollar(from,to,sum);
                    to.deposit(newSumTo);
                }else {
                    System.out.println("Недостаточно средств для перевода");
                }
            }
        }

    }

    public void transferBetweenBanks(final String accountIdFrom, final String accountIdTo, BigDecimal sum, Bank bankSender, Bank bankReceiver){
        Account from = null;
        Account to = null;
        Person sender = null;
        Person receiver = null;

        for(List<Account> listAccount:bankSender.getData().values()){
            for(Account accountSearcher : listAccount){
                if(accountSearcher.getId().equals(accountIdFrom)){
                    from = accountSearcher;
                }
            }
        }

        for(List<Account> listAccount:bankReceiver.getData().values()){
            for(Account accountSearcher : listAccount){
                if(accountSearcher.getId().equals(accountIdTo)){
                    to = accountSearcher;
                }
            }
        }

        for(Map.Entry<Person, List<Account>> mapPersonList : bankSender.getData().entrySet()){
            if(mapPersonList.getValue().contains(from)){
                sender = mapPersonList.getKey();
            }
        }

        for (Map.Entry<Person, List<Account>> mapPersonList : bankReceiver.getData().entrySet()){
            if(mapPersonList.getValue().contains(to)){
                receiver = mapPersonList.getKey();
            }
        }

        if(from == null || to == null){
            System.out.println("Аккаунт отправитель или аккаунт получатель не найдены");
        } else{
            synchronized (from){
                synchronized (to){
                    System.out.println("Отправитель : \n " + sender.toString() + "\n   Наименование банка отправителя: " + bankSender.getName());
                    System.out.println("Аккаунт Отправителя: \n   " + from.toString());
                    System.out.println("Получатель : \n " + receiver.toString() + "\n   Наименование банка получателя: " + bankReceiver.getName());
                    System.out.println("Аккаунт Получатель: \n   " + to.toString());
                    if(from.getBalance().compareTo(sum) == 1){
                        System.out.println("   Сумма перевода = " + sum);
                        TransferCommission transferCommission = new TransferCommission();
                        from.withdraw(sum);
                        BigDecimal sumInUSD = sum.multiply(from.geteCurrency().getRelationToDollar());
                        BigDecimal commission =TransferCommission.sumWithCommission(sumInUSD);
                        bankSender.addBankBalance(commission);
                        BigDecimal newSumTo = Account.transferSumToDollar(from,to,sum);
                        to.deposit(newSumTo.subtract(commission.divide(to.geteCurrency().getRelationToDollar(),6,RoundingMode.HALF_DOWN)));
                        System.out.println(transferCommission.toString());
                        System.out.println("Перевод Осуществился");
                        System.out.println("Аккаунт Отправителя: \n   " + from.toString());
                        System.out.println("Аккаунт Получатель: \n   " + to.toString());
                    }else {
                        System.out.println("Недостаточно средств для перевода");
                    }
                }
            }
        }

    }

    @Override
    public String toString() {
        BigDecimal sum = sumAccountsMoneyInBank();
        return "Банк: " + name + "\n Общее количество денег на счетах банка = " + sum + "\nПрибыль = " + getBankBalance();
    }

    //    //Получение Id Клиента по акаунту
//
//    public String getIdPersonFromAccount(Account account){
//        Collection<String> keyCollection = data.keySet();
//        String myId = null;
//        for(String key: keyCollection){
//            List<Account> accounts = data.get(key);
//            if(key!=null){
//                if(account.equals(accounts)){
//                    myId = key;
//                }
//            }
//        }
//        return myId;
//    }


}
