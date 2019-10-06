package dto;

public class AsusComputer extends Computer {
    public AsusComputer(Ram ram, Hdd hdd) {
        super(ram, hdd);
    }

    public AsusComputer(int ram, int hdd)
    {
        super(new Ram(ram), new Hdd(hdd));
    }

    public void work() {
        System.out.println("Я асус! Я работаю");
    }

    public boolean checkFingerOnFingerSkan(String finger){
        return true;
    }

    @Override
    public void on() {
        super.on();
        System.out.println("hdd: " + this.getHdd().getCapacity() + " ram: " + this.getRam().getSize());
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
