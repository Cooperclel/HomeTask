package exercise1;

public class TestTryCatchFinally implements ITestTryCatchFinally{
    private int a;
    private int b;

    public TestTryCatchFinally(int a, int b){
        this.a = a;
        this.b = b;
    }

    public void testTryCatch(){
        try {
            int result = a/b;
            System.out.println(result);
        }catch (ArithmeticException e){
            System.out.println("Нельзя делить на ноль");
        }
    }

    public void testTryCatchFinally(){
        try {
            int result = a/b;
            System.out.println(result);
        }catch (ArithmeticException e){
            System.out.println("Нельзя делить на ноль");
        }finally {
            System.out.println("ArithmeticException");
        }
    }

    public void testTryFinally() throws ArithmeticException{
        try {
            int result = a/b;
            System.out.println(result);
        }finally {
            System.out.println("ArithmeticException");
        }
    }
}
