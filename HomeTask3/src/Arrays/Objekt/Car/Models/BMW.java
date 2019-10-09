package Arrays.Objekt.Car.Models;

import Arrays.Objekt.Car.Car;
import Arrays.Objekt.Motor.Motor;
import Arrays.Objekt.Wheel.Wheel;

public class BMW extends Car {

    public BMW(Motor motor, Wheel wheel) {
        super(motor, wheel);
    }

    public void carName(){
        System.out.println("Название BMW");
    }

    public String toString(){
        return "BMW:\n " + getMotor() + getWheel();
    }
}
