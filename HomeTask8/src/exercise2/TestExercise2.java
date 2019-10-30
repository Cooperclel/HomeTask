package exercise2;

import exercise2.exceptions.LeptopIsNotValid;
import exercise2.exceptions.LeptopIsNotValidRam;
import exercise2.leptopsModel.Acer;
import exercise2.leptopsModel.HP;
import exercise2.leptopsModel.Lenovo;

public class TestExercise2 {
    public static void main(String[] args) throws LeptopIsNotValid, LeptopIsNotValidRam {
        try {
            Leptops lenovo1 = new Lenovo(1, 8, "Core i5");
            Leptops lenovo2 = new Lenovo(4, 4, "Core i5");
            Leptops lenovo3 = new Lenovo(1, 16, "Core i7");

            Leptops acer1 = new Acer(1, 8, "Core i7");
            Leptops acer2 = new Acer(3, 4, "Core i5");
            Leptops acer3 = new Acer(8, 2, "Core i3");

            Leptops hp1 = new HP(1, 16, "Core i7");
            Leptops hp2 = new HP(7, 4, "Core i3");
            Leptops hp3 = new HP(2, 8, "Core i5");

            System.out.println(lenovo1.toString());
            System.out.println(lenovo2.toString());
            System.out.println(lenovo3.toString());

            System.out.println(acer1.toString());
            System.out.println(acer2.toString());
            System.out.println(acer3.toString());

            System.out.println(hp1.toString());
            System.out.println(hp2.toString());
            System.out.println(hp3.toString());

        }catch (LeptopIsNotValid | LeptopIsNotValidRam e){
            System.out.println(e.getMessage());
        }


    }
}
