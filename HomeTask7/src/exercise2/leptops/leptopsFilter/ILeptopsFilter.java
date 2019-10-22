package exercise2.leptops.leptopsFilter;

import exercise2.leptops.Leptops;

import java.util.Collection;
import java.util.List;

public interface ILeptopsFilter {
    List<Leptops> filter(Collection<Leptops> noFilterLeptops);
}
