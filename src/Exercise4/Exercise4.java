package Exercise4;

import Exercise4.ExampleIComputer.*;

public class Exercise4 {
    public static void main(String args[]){
        IComputer c1 = new AsusComputer(new Ram(10), new Hdd(1008));
        IComputer c2 = new AcerComputer(new Ram(10), new Hdd(3002));

        boolean proof;
        proof = c2 instanceof AcerComputer;
        if (proof == true){
            System.out.println("Это AcerComputer");
        } else {
            System.out.println("ClassCastException");
        }

        proof = c1 instanceof AcerComputer;
        if (proof == true){
            System.out.println("Это AcerComputer");
        } else {
            System.out.println("ClassCastException");
        }
    }
}
