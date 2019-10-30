package exercise1;

import javax.swing.table.TableRowSorter;

public class TestExercise1 {
    public static void main(String[] args) {

        ITestTryCatchFinally test = new TestTryCatchFinally(6, 0);

        System.out.println("Exercise 1.1");
        test.testTryCatch();

        /*
        * try catch замечает ошибку, и продолжает программу
        * с try finally программа прекраш=щает работу из-за ошибки но выполняет то, что прописано в finally
        * */

        System.out.println("Exercise 1.3");
        test.testTryCatchFinally();

        System.out.println("Exercise 1.2");
        test.testTryFinally();


    }
}
