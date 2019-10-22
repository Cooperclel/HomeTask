package exercise2;

import exercise2.leptops.Leptops;
import exercise2.leptops.ILeptops;
import exercise2.leptops.leptopsFilter.LeptopsFilterAge;
import exercise2.leptops.leptopsFilter.LeptopsFilterCpu;
import exercise2.leptops.leptopsFilter.LeptopsFilterRam;
import exercise2.leptops.leptopModel.Acer;
import exercise2.leptops.leptopModel.HP;
import exercise2.leptops.leptopModel.Lenovo;

import java.util.ArrayList;
import java.util.List;

public class TestExercise2 {
    public static void main(String[] args){
        Leptops lenovo1 = new Lenovo(2,8, "Core i5");
        Leptops lenovo2 = new Lenovo(4,4, "Core i5");
        Leptops lenovo3 = new Lenovo(1,16, "Core i7");

        Leptops acer1 = new Acer(1,8,"Core i7");
        Leptops acer2 = new Acer(3,4,"Core i5");
        Leptops acer3 = new Acer(8,2,"Core i3");

        Leptops hp1 = new HP(1, 16, "Core i7");
        Leptops hp2 = new HP(7, 4, "Core i3");
        Leptops hp3 = new HP(2, 8, "Core i5");

        List<Leptops> leptopsList = new ArrayList<>();

        leptopsList.add(lenovo1);
        leptopsList.add(lenovo2);
        leptopsList.add(lenovo3);

        leptopsList.add(acer1);
        leptopsList.add(acer2);
        leptopsList.add(acer3);

        leptopsList.add(hp1);
        leptopsList.add(hp2);
        leptopsList.add(hp3);


        LeptopsFilterAge leptopsFilterAge = new LeptopsFilterAge(2);
        LeptopsFilterRam leptopsFilterRam = new LeptopsFilterRam(2);
        LeptopsFilterCpu leptopsFilterCpu = new LeptopsFilterCpu("Core i7");

        FilterApplication filterApplication = new FilterApplication();

        filterApplication.filter(leptopsList, leptopsFilterAge);
        filterApplication.filter(leptopsList, leptopsFilterCpu);
        filterApplication.filter(leptopsList, leptopsFilterRam);

        FilterApplication.sortCollection(leptopsList);

    }
}
