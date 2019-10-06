package operations;

public class ShiftNegativeNumber implements IShift {
    private int a;
    private int b;

    public ShiftNegativeNumber(int a, int b){
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
        if(a<0) {
            int result;
            result = a >> b;
            System.out.println("Результат сдвига вправо:" + result);
        } else System.out.println("Введите отрицательные числа");
    }

    public void shiftLeft(){
        if(a<0) {
            int result;
            result = a << b;
            System.out.println("Результат сдвига влево:" + result);
        }else System.out.println("Введите отрицательные числа");
    }

    public void shiftFillingRight(){
        if(a<0) {
            int result;
            result = a >>> b;
            System.out.println("Результат сдвига вправо с заполнением нулями:" + result);
        }else System.out.println("Введите отрицательные числа");
    }
}
