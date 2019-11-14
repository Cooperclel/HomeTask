package account;

import person.Person;

import java.math.BigDecimal;

public enum ECurrency {
    EUR("Евро", new BigDecimal(1.10)),
    USD("Доллар", new BigDecimal(1.0)),
    GBP("Фунт Стерлинг", new BigDecimal(1.28)),
    JPY("Иена", new BigDecimal(0.0092)),
    CNY("Юань", new BigDecimal(0.14)),
    RUB("Российский Рубль", new BigDecimal(0.016)),
    BTC("Биткойн", new BigDecimal(9039.0)),
    BLR("Белорусский Рубль", new BigDecimal(0.49));


    private String nameCurrency;
    private BigDecimal relationToDollar;

    ECurrency(String nameCurrency, BigDecimal relationToDollar){
        this.nameCurrency = nameCurrency;
        this.relationToDollar = relationToDollar;
    }

    public BigDecimal getRelationToDollar() {
        return relationToDollar;
    }

    public void setRelationToDollar(BigDecimal relationToDollar) {
        this.relationToDollar = relationToDollar;
    }

    public String getNameCurrency() {
        return nameCurrency;
    }

    public void setNameCurrency(String nameCurrency) {
        this.nameCurrency = nameCurrency;
    }

    @Override
    public String toString() {
        return "Валюта{ "+ nameCurrency + '}';
    }
}
