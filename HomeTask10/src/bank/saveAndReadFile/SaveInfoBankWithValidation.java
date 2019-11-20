package bank.saveAndReadFile;

import bank.Bank;

import java.io.Serializable;
import java.util.List;

public class SaveInfoBankWithValidation extends SaveInfoBank implements Serializable {

    @Override
    public void saveInfoBank(List<Bank> listBank, String fileName){
        validate(listBank);
        super.saveInfoBank(listBank, fileName);
    }

    public void validate(List<Bank> list){
        for (Bank bank : list){
            if(bank.getName() == null){
                throw new IllegalArgumentException("Все очень плохо!");
            }
        }
    }
}
