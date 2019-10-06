package logical_operators;

public class BitwiseOperators implements IBitwiseOpertors {
    private int a;
    private int b;

    public BitwiseOperators(int a, int b){
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

    public void bitwiseAND(){
        int result = a & b;
        System.out.println("Побитовый оператор И");
        System.out.println("Результат: " + result);
    }

    public void bitwiseOR(){
        int result = a | b;
        System.out.println("Побитовый оператор ИЛИ");
        System.out.println("Результат: " + result);
    }

    public void bitwiseXOR(){
        int result = a ^ b;
        System.out.println("Побитовый оператор XOR");
        System.out.println("Результат: " + result);
    }
}
