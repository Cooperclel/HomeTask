package Exercise4.ExampleIComputer;

public class AcerComputer extends Computer {
    public AcerComputer(Ram ram, Hdd hdd) {
        super(ram, hdd);
    }

    public AcerComputer(int ram, int hdd)
    {
        super(new Ram(ram), new Hdd(hdd));
    }

    public void work() {
        System.out.println("Я acer! Я работаю");
    }

    public boolean checkFingerOnFingerSkan(String finger){
        return true;
    }

    // @Override
   /* public void on() {
        super.on();
        System.out.println("hdd: " + this.getHdd().getCapacity() + " ram: " + this.getRam().getSize());
    }*/


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
