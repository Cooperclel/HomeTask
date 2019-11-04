package exercise3_4;

import java.io.Serializable;
import java.util.Comparator;

public class Person implements Comparator<Person>, Serializable {
    private int id;
    private String name;
    private float avgValue;

    public Person(int id, String name, float avgValue) {
        this.id = id;
        this.name = name;
        this.avgValue = avgValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAvgValue() {
        return avgValue;
    }

    public void setAvgValue(float avgValue) {
        this.avgValue = avgValue;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avgValue=" + avgValue +
                '}';
    }



    public int compare(Person p1, Person p2) {
        if (p1.getAvgValue() > p2.getAvgValue()) return -1;
        if (p1.getAvgValue() < p2.getAvgValue()) return 1;
        return 0;
    }
}
