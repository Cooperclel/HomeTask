package Arrays.Objekt.Car.Models;
import Arrays.Objekt.Car.Car;
import Arrays.Objekt.Motor.Motor;
import Arrays.Objekt.Wheel.Wheel;

public class Bugati extends Car {
    public Bugati(Motor motor, Wheel wheel) {
        super(motor, wheel);
    }
    public void carName(){
        System.out.println("Название Bugati");
    }

    public String toString(){
        return "Bugati:\n " + getMotor() + getWheel();
    }
}

