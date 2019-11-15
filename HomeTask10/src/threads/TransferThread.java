package threads;

import account.Account;
import bank.Bank;

import java.math.BigDecimal;
import java.util.Random;

public class TransferThread implements Runnable {
    private final Account account1;
    private final Account account2;
    private final Bank bank;
    private Random rnd = new Random();

    public TransferThread(Account account1, Account account2, Bank bank) {
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
