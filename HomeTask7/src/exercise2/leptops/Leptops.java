package exercise2.leptops;

public abstract class Leptops implements ILeptops{
    private int age;
    private int ram;
    private String cpu;

    public Leptops (int age, int ram, String cpu){
        this.age = age;
        this.ram = ram;
        this.cpu = cpu;
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
                "age=" + age +
                ", ram=" + ram +
                ", cpu='" + cpu + '\'' +
                '}';
    }

    public int compareTo(Leptops leptop) {
        if(this.getAge()>leptop.getAge()){return 1;}
        if(this.getAge()<leptop.getAge()){return -1;}
        return 0;
    }
}
