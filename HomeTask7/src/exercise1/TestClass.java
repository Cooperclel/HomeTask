package exercise1;

@Version("1.0.1")
public class TestClass implements ITestClass {
    private String name;
    private int age;

    public TestClass (String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void showInformation(){
        System.out.println("Имя " + name + "\n" + "Возраст " + age);
    }
}
