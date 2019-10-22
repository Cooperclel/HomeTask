package exercise2.leptops.leptopsFilter;

import exercise2.leptops.Leptops;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LeptopsFilterRam implements ILeptopsFilter{
    private int ram;

    public LeptopsFilterRam(int ram){
        this.ram = ram;
    }

    public List<Leptops> filter(Collection<Leptops> noFilterList){
        List filterList = new ArrayList();
        System.out.println("Производим фильтрацию по ram");
        for (Leptops leptops:noFilterList) {
            if(leptops.getRam() == this.ram){
                filterList.add(leptops);
            }
        }
        for (int i = 0; i<filterList.size(); i++){
            System.out.println(filterList.get(i));
        }
        return filterList;
    }
}
