package Arrays.Objekt.Car.Models;

import Arrays.Objekt.Car.Car;
import Arrays.Objekt.Motor.Motor;
import Arrays.Objekt.Wheel.Wheel;

public class Masda extends Car {
    public Masda(Motor motor, Wheel wheel) {
        super(motor, wheel);
    }

    public void carName(){
        System.out.println("Название Masda");
    }
    public String toString(){
        return "Masda:\n " + getMotor() + getWheel();
    }
}
