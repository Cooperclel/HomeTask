package Exercise1;

import Exercise1.IShift;

public class ShiftInteger implements IShift {
    private int a;
    private int b;

    public ShiftInteger(int a, int b){
        this.a = a;
        this.b = b;
    }

    public void setA(int a){
        this.a = a;
    }
    public int getA(){
        return a;
    }

    public void setB(int b){
        this.b = b;
    }
    public int getB(){
        return b;
    }

    public void shiftRight(){
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
    }



}
