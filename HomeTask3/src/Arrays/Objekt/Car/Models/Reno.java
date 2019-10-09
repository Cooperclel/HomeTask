package Arrays.Objekt.Car.Models;
import Arrays.Objekt.Car.Car;
import Arrays.Objekt.Motor.Motor;
import Arrays.Objekt.Wheel.Wheel;

public class Reno extends Car {

    public Reno(Motor motor, Wheel wheel) {
        super(motor, wheel);
    }

    public void carName(){
        System.out.println("Название Reno");
    }

    public String toString(){
        return "Reno:\n " + getMotor() + getWheel();
    }
}