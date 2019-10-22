package exercise2.leptops.leptopsFilter;

import exercise2.leptops.Leptops;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LeptopsFilterCpu implements ILeptopsFilter {
    private String cpu;

    public LeptopsFilterCpu(String cpu){
        this.cpu = cpu;
    }

    public List<Leptops> filter(Collection<Leptops> noFilterList){
        List filterList = new ArrayList();
        System.out.println("Производим фильтрацию по cpu");
        for (Leptops leptops:noFilterList) {
            if(leptops.getCpu() == this.cpu){
                filterList.add(leptops);
            }
        }
        for (int i = 0; i<filterList.size(); i++){
            System.out.println(filterList.get(i));
        }
        return filterList;
    }
}
