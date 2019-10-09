package Exercise5;

public class Equations implements IEquations {
    private int integerResult;
    private boolean booleanResult;

    public void setIntegerResult(int integerResult) {
        this.integerResult = integerResult;
    }
    public int getIntegerResult() {
        return integerResult;
    }

    public void setBooleanResult(boolean booleanResult) {
        this.booleanResult = booleanResult;
    }
    public boolean getBooleanResult() {
        return booleanResult;
    }

    @Override
    public void equation1(int myResult1) {
        integerResult = 5+8/8;
        if(myResult1 == integerResult){
            System.out.println("1) Результат верен: " + integerResult);
        } else{
            System.out.println("1) Результат ложный. Нужный результа: " + integerResult);
        }
    }

    public void equation2(int myResult2) {
        integerResult = (5+2)/8;
        if(myResult2 == integerResult){
            System.out.println("2) Результат верен: " + integerResult);
        } else{
            System.out.println("2) Результат ложный. Нужный результа: " + integerResult);
        }
    }

    public void equation3(int myResult3) {
        int i = 2;
        integerResult = (5 + i++)/8;
        if(myResult3 == integerResult){
            System.out.println("3) Результат верен: " + integerResult);
        } else{
            System.out.println("3) Результат ложный. Нужный результа: " + integerResult);
        }
    }


    public void equation4(int myResult4) {
        int i = 2;
        int b = 8;
        integerResult = (5 + i++)/--b;
        if(myResult4 == integerResult){
            System.out.println("4) Результат верен: " + integerResult);
        } else{
            System.out.println("4) Результат ложный. Нужный результа: " + integerResult);
        }
    }

    public void equation5(int myResult5) {
        int i = 2;
        int b = 8;
        integerResult = (5 * 2 >> i++)/--b;
        if(myResult5 == integerResult){
            System.out.println("5) Результат верен: " + integerResult);
        } else{
            System.out.println("5) Результат ложный. Нужный результа: " + integerResult);
        }
    }

    public void equation6(int myResult6) {
        int i = 2;
        int b = 8;
        integerResult = (5+7>20?68:22*2>>i++)/--b;
        if(myResult6 == integerResult){
            System.out.println("6) Результат верен: " + integerResult);
        } else{
            System.out.println("6) Результат ложный. Нужный результа: " + integerResult);
        }
    }

    /*public void equation7(int myResult7) {
        int i=2;
        int b=8;
        integerResult = (5+7>20?68=>:22*2>>i++)/--b;
        if(myResult7 == integerResult){
            System.out.println("7) Результат верен: " + integerResult);
        } else{
            System.out.println("7) Результат ложный. Нужный результа: " + integerResult);
        }
    }*/

    public void equation8(boolean myResult8) {
        booleanResult = 6-2>3 && 12*12<=119;
        if(myResult8 == booleanResult){
            System.out.println("8) Результат верен: " + booleanResult);
        } else{
            System.out.println("8) Результат ложный. Нужный результа: " + booleanResult);
        }
    }

    public void equation9(boolean myResult9) {
        booleanResult = true && false;
        if(myResult9 == booleanResult){
            System.out.println("9) Результат верен: " + booleanResult);
        } else{
            System.out.println("9) Результат ложный. Нужный результа: " + booleanResult);
        }
    }

}
