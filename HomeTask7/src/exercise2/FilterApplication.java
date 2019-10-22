package exercise2;


import exercise2.leptops.ILeptops;
import exercise2.leptops.Leptops;
import exercise2.leptops.leptopsFilter.ILeptopsFilter;
import exercise2.leptops.leptopsFilter.LeptopsFilterAge;

import java.util.Collection;
import java.util.List;

public class FilterApplication<T extends Collection,E extends ILeptopsFilter> {

    public  Collection filter(T collection, E type){
        collection= (T) type.filter(collection);
        return collection;
    }

    public static List<Leptops> sortCollection(List<Leptops> filterList){
        filterList.sort(Leptops::compareTo);
        System.out.println("Сортировка");
        for (int i = 0; i<filterList.size(); i++){
            System.out.println(filterList.get(i));
        }
        return filterList;
    }

}
