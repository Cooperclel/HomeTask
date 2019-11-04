package exercise2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MathRounding {

    public static double roundingBigDecimal(double number, int afterComma){
        if (afterComma<0){
            throw new IllegalArgumentException();
        }
        BigDecimal result = new BigDecimal(Double.toString(number));
        result = result.setScale(afterComma, RoundingMode.HALF_DOWN);
        return result.doubleValue();
    }

    public static double mathRound(double number, int afterComma){
        double scale = Math.pow(10,afterComma);
        return Math.round(number*scale)/scale;
    }
}
