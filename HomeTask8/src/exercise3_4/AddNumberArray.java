package exercise3_4;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AddNumberArray {
    private int number;
    private int[] numbers = new int[0];

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public void addNumbers(int number){
        this.addNumbers(new int [] {number});
    }

    public void addNumbers(int [] numbers){
        if (numbers != null && numbers.length != 0){
            this.numbers = Arrays.copyOf(this.numbers, this.numbers.length + numbers.length);
            int numbersLenght = numbers.length;
            for(int num: numbers){
                this.numbers[this.numbers.length - numbersLenght--] = num;
            }
        }
    }

    @Override
    public String toString() {
        return "numbers={" + Arrays.toString(numbers) +
                '}';
    }
}
