package Exercise1;

public class Exercise1 {
    public static void main(String args[]){
        IShift i1 = new ShiftInteger(10,1);

        IShift mi1 = new ShiftNegativeNumber(-1,2);

        System.out.println("Оператор сдвига с положительным числом");
        System.out.println("");
        i1.shiftRight();
        i1.shiftLeft();
        i1.shiftFillingRight();

        System.out.println("Оператор сдвига с отрицательным числом");
        System.out.println("");
        mi1.shiftRight();
        mi1.shiftLeft();
        mi1.shiftFillingRight();
    }
}
