package bank.saveAndReadFile;

import bank.Bank;

import java.util.List;

public class SaveInfoBankWithValidation extends SaveInfoBank{

    @Override
    public void saveInfoBank(List<Bank> listBank){
        validate(listBank);
        super.saveInfoBank(listBank);
    }

    public void validate(List<Bank> list){
        for (Bank bank : list){
            if(bank.getName() == null){
                throw new IllegalArgumentException("Все очень плохо!");
            }
        }
    }
}
