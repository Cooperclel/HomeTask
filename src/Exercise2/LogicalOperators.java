package Exercise2;

import Exercise2.ILogicalOperators;

public class LogicalOperators implements ILogicalOperators {
    private boolean a;
    private boolean b;

    public LogicalOperators(boolean a, boolean b){
        this.a = a;
        this.b = b;
    }

    public void setA(boolean a){
        this.a = a;
    }
    public boolean getA(){
        return a;
    }

    public void setB(boolean b){
        this.b = b;
    }
    public boolean getB(){
        return b;
    }

    public void logicalAND(){
        boolean result = a && b;
        System.out.println("Логический оператор И");
        System.out.println("Результат: " + result);
    }

    public void logicalOR(){
        boolean result = a || b;
        System.out.println("Логический оператор ИЛИ");
        System.out.println("Результат: " + result);
    }


}
