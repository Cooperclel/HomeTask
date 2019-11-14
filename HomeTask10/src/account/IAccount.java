package account;

import java.math.BigDecimal;

public interface IAccount {
    void deposit(BigDecimal sum);
    void withdraw(BigDecimal sum);
    void transferFromCurrencyToDollar();
}
