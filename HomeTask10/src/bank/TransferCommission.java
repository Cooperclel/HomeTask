package bank;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TransferCommission {
    private BigDecimal commission = new BigDecimal(0.01);
    private BigDecimal minSumOfCommission = new BigDecimal(0.5); // Минимальная коммиссия в USD

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getMinSumOfCommission() {
        return minSumOfCommission;
    }

    public void setMinSumOfCommission(BigDecimal minSumOfCommission) {
        this.minSumOfCommission = minSumOfCommission;
    }

    public static BigDecimal sumWithCommission(BigDecimal sum){
        TransferCommission transferCommission = new TransferCommission();
        BigDecimal commission = transferCommission.getCommission();
        BigDecimal minSumOfCommission = transferCommission.getMinSumOfCommission();
        BigDecimal sumOfCommission = sum.multiply(commission);
        if(sumOfCommission.compareTo(minSumOfCommission) >= 0){
            return sumOfCommission;
        }else{
            return minSumOfCommission;
        }
    }

    @Override
    public String toString() {
        return "Коммиссия при переводе состаяляет " + commission.multiply(new BigDecimal(100)).setScale(2,RoundingMode.HALF_DOWN) + " %\n" +
                "Минимальная сумма коммиссии при переводе " + minSumOfCommission + " USD";
    }
}
