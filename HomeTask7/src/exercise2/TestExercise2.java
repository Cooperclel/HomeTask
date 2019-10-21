package exercise2;

import exercise2.leptops.ILeptops;
import exercise2.leptops.Leptops;
import exercise2.leptops.leptopModel.Acer;
import exercise2.leptops.leptopModel.HP;
import exercise2.leptops.leptopModel.Lenovo;

import java.util.ArrayList;
import java.util.List;

public class TestExercise2 {
    public static void main(String[] args){
        ILeptops lenovo1 = new Lenovo(2,8, "Core i5");
        ILeptops lenovo2 = new Lenovo(4,4, "Core i5");
        ILeptops lenovo3 = new Lenovo(1,16, "Core i7");

        ILeptops acer1 = new Acer(1,8,"Core i7");
        ILeptops acer2 = new Acer(3,4,"Core i5");
        ILeptops acer3 = new Acer(8,2,"Core i3");

        ILeptops hp1 = new HP(1, 16, "Core i7");
        ILeptops hp2 = new HP(7, 4, "Core i3");
        ILeptops hp3 = new HP(2, 8, "Core i5");

        List<ILeptops> leptopsList = new ArrayList<>();

        leptopsList.add(lenovo1);
        leptopsList.add(lenovo2);
        leptopsList.add(lenovo3);

        leptopsList.add(acer1);
        leptopsList.add(acer2);
        leptopsList.add(acer3);

        leptopsList.add(hp1);
        leptopsList.add(hp2);
        leptopsList.add(hp3);



    }
}
