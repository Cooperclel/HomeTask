package person;

import account.Account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Person implements Serializable {
    private final String id;
    private String name;
    private List<Account> accounts = new ArrayList<>();

    public Person(String id){
        this.id = id;
    }

    public Person(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    public synchronized void removeAccount(Account account){
        //TODO добавить экспешен если аккаунта не нашли
            List<Account> newAccountList = new ArrayList<>(accounts);
            newAccountList.remove(account);
            accounts = Collections.unmodifiableList(newAccountList);
    }

    @Override
    public String toString() {
        return "Клиент{" +
                "id Клиента = " + id + '\'' +
                ", Имя Клиента = " + name +
                '}';
    }
}
