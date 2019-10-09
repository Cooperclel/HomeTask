package Arrays.Objekt.Car;
import Arrays.Objekt.Motor.Motor;
import Arrays.Objekt.Wheel.Wheel;

public abstract class Car implements ICar{
    private Motor motor;
    private Wheel wheel;

    public Car(Motor motor, Wheel wheel){
        this.motor = motor;
        this.wheel = wheel;
    }

    public Motor getMotor() {
        return motor;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void seatPlaces(int n){
        System.out.println("Количество мест для пасажиров = " + n);
    }

    public void informationCarLicenseCategory(String category){
        if (category == "A"){
            System.out.println("Нужны Права категории А на мотоцикл");
        }
        if (category == "B"){
            System.out.println("Нужны Права категории B на легковой автомобиль");
        }
        if (category == "C"){
            System.out.println("Нужны Права категории С на грузовики");
        }
        if (category == "D"){
            System.out.println("Нужны Права категории D на автобус");
        }
        else {
            System.out.println("Не верная категория");
        }
    }

    public void openCarWithKey(boolean p){
        if (p = true){
            System.out.println("Ключ верный - дверь открыта");
        }
        else {
            System.out.println("Ключ не верный - у вас не верный ключ");
        }
    }

    public abstract void carName();


}
