package exercise3_4;

import java.util.Comparator;

public class SortedAvgValue implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if (p1.getAvgValue() > p2.getAvgValue()) return -1;
        if (p1.getAvgValue() < p2.getAvgValue()) return 1;
        return 0;
    }
}
