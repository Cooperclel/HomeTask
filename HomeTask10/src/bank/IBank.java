package bank;

import account.Account;
import person.Person;

import java.math.BigDecimal;

public interface IBank {
    void addClient(Person p);
    void delClient(Person p);
    void transferInOneBank(final Account from, final Account to, BigDecimal sum, Bank bank);
    void transferBetweenBanks(final String accountIdFrom, final String accountIdTo, BigDecimal sum, Bank bankSender, Bank bankReceiver);
}
