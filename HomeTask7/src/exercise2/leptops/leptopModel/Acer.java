package exercise2.leptops.leptopModel;

import exercise2.leptops.Leptops;

public class Acer extends Leptops {
    public Acer(int age, int ram, String cpu){
        super(age, ram, cpu);
    }

    public void on(){
        System.out.println("Leptop Acer is on");
    }

    public void off(){
        System.out.println("Leptop Acer is off");
    }
}
