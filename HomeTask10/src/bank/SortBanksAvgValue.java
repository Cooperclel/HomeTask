package bank;

import java.math.BigDecimal;
import java.util.Comparator;

public class SortBanksAvgValue implements Comparator<Bank> {
    @Override
    public int compare(Bank bank1, Bank bank2){
        BigDecimal sum1 = bank1.sumAccountsMoneyInBank();
        BigDecimal sum2 = bank2.sumAccountsMoneyInBank();
        if(sum1.compareTo(sum2) == -1) return 1;
        if(sum1.compareTo(sum2) == 1) return -1;
        return 0;
    }
}
