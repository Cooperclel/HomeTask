package exercise2.leptops.leptopModel;

import exercise2.leptops.Leptops;

public class Lenovo extends Leptops {
    public Lenovo(int age, int ram, String cpu){
        super(age, ram, cpu);
    }

    public void on(){
        System.out.println("Leptop Lenovo is on");
    }

    public void off(){
        System.out.println("Leptop Lenovo is off");
    }

    public int compareTo(Lenovo lenovo) {
        if(this.getAge()>lenovo.getAge()){return 1;}
        if(this.getAge()<lenovo.getAge()){return -1;}
        return 0;
    }

}
