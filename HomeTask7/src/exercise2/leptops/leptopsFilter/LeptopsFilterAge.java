package exercise2.leptops.leptopsFilter;

import exercise2.leptops.Leptops;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LeptopsFilterAge implements ILeptopsFilter{

    private int age;

    public LeptopsFilterAge(int age){
        this.age = age;
    }

    public List<Leptops> filter(Collection<Leptops> noFilterList){
        List filterList = new ArrayList();
        System.out.println("Производим фильтрацию по age");
        for (Leptops leptops:noFilterList) {
            if(leptops.getAge() == this.age){
                filterList.add(leptops);
            }
        }

        for (int i = 0; i<filterList.size(); i++){
            System.out.println(filterList.get(i));
        }
        return filterList;
    }
}
