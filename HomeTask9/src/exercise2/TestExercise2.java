package exercise2;

import java.text.DecimalFormat;

public class TestExercise2 {
    public static void main(String[] args){
        double number = 3.46723617827;
        float number1 = 3.34f;
        System.out.println("Округление при помощи класса DecimalFormat:");
        DecimalFormat df = new DecimalFormat("###.###"); // если поставить запятую вместо точки то округление будет до целого числа
        System.out.println(df.format(number) + "\n");

        System.out.println("Округление при помощи BigDecimal");
        double result = MathRounding.roundingBigDecimal(number,4);
        System.out.println(result + "\n");

        System.out.println("Округление при помощи round()");
        System.out.println(MathRounding.mathRound(number1, 1) + "\n");
    }

}
