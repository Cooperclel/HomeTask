package exercise2.leptopsModel;

import exercise2.Leptops;
import exercise2.exceptions.LeptopIsNotValid;
import exercise2.exceptions.LeptopIsNotValidRam;

public class HP extends Leptops {
    public HP(int age, int ram, String cpu) throws LeptopIsNotValid, LeptopIsNotValidRam {
        super(age, ram, cpu);
        if(ram>16){
            throw new LeptopIsNotValidRam("Слишком большое ram");
        } else{
            super.setRam(ram);
        }
    }

    public void on(){
        System.out.println("Leptop HP is on");
    }

    public void off(){
        System.out.println("Leptop HP is off");
    }
}
