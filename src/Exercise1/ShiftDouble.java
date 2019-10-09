package Exercise1;

/**
 * Проводить операции сдвига с переменными типа double нельзя
 * (выдает ошибку при конпиляции)
 */
public class ShiftDouble/*implement IShift*/ {
    private double a;
    private double b;

    public ShiftDouble(double a, double b){
        this.a = a;
        this.b = b;
    }

    public void setA(double a){
        this.a = a;
    }
    public double getA(){
        return a;
    }

    public void setB(double b){
        this.b = b;
    }
    public double getB(){
        return b;
    }

    /*public void shiftRight(){
        int result;
        result = a>>b;
        System.out.println("Результат сдвига вправо:" + result);
    }

    public void shiftLeft(){
        int result;
        result = a<<b;
        System.out.println("Результат сдвига влево:" + result);
    }

    public void shiftFillingRight(){
        int result;
        result = a>>>b;
        System.out.println("Результат сдвига вправо с заполнением нулями:" + result);
    }*/
}
