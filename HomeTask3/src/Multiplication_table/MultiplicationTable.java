package Multiplication_table;

public class MultiplicationTable {
    private int x = 0;
    public void createMultiplicationTable(){
        for (int i=0; i<=10; i++){
            System.out.println("Умнажение на " + x + ")");
            x++;
            for (int j=0; j<=10; j++){
                int b = i*j;
                System.out.println(j + "*" + i + "=" + b);
            }
        }
    }
}
