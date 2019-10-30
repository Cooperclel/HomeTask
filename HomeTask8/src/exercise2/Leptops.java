package exercise2;

import exercise2.exceptions.LeptopIsNotValid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Leptops implements ILeptops {
    private int age;
    private int ram;
    private String cpu;

    public Leptops (int age, int ram, String cpu) throws LeptopIsNotValid {
        Pattern pattern = Pattern.compile("(^Core\\si)");
        Matcher matcher = pattern.matcher(cpu);
        if (age < 0){
            throw new LeptopIsNotValid("Возраст не может быть меньше нуля");
        }else {
            this.age = age;
        }

        this.ram = ram;

        if(!matcher.find()){
            throw  new LeptopIsNotValid("Не верный cpu");
        }else{
            this.cpu = cpu;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }


    @Override
    public String toString() {
        return "Leptops{" + this.getClass() +
                " age=" + age +
                ", ram=" + ram +
                ", cpu='" + cpu + '\'' +
                '}';
    }
}
