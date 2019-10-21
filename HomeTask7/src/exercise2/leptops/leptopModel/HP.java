package exercise2.leptops.leptopModel;

import exercise2.leptops.Leptops;

public class HP extends Leptops {
    public HP(int age, int ram, String cpu){
        super(age, ram, cpu);
    }

    public void on(){
        System.out.println("Leptop HP is on");
    }

    public void off(){
        System.out.println("Leptop HP is off");
    }
}
