package account;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Account implements IAccount{
    private final String id;
    private BigDecimal balance;
    private ECurrency eCurrency;

    public Account(String id){
        this.id = id;
    }

    public Account(String id, BigDecimal balance, ECurrency eCurrency){
        this.id = id;
        this.balance = balance;
        this.eCurrency = eCurrency;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public ECurrency geteCurrency() {
        return eCurrency;
    }

    public void seteCurrency(ECurrency eCurrency) {
        this.eCurrency = eCurrency;
    }

    public void deposit(BigDecimal sum){
        this.balance = this.balance.add(sum);
    }
    public void withdraw(BigDecimal sum){
        this.balance = this.balance.subtract(sum);
    }

    public void transferFromCurrencyToDollar(){
        BigDecimal exchangeRates = this.geteCurrency().getRelationToDollar();
        this.balance = this.balance.multiply(exchangeRates);
    }

    public static BigDecimal transferSumToDollar(Account from, Account to, BigDecimal sum){
        BigDecimal exchangeRatesFrom = from.geteCurrency().getRelationToDollar();
        BigDecimal exchangeRatesTo = to.geteCurrency().getRelationToDollar();
        BigDecimal newSumFrom = sum.multiply(exchangeRatesFrom);
        BigDecimal newSumTo = newSumFrom.divide(exchangeRatesTo, 6, RoundingMode.HALF_DOWN);
        return newSumTo;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", balance= " + balance +
                ", Currency: " + eCurrency +
                '}';
    }
}
