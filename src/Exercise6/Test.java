package Exercise6;

public class Test {
    private Integer k;
    private int z;
    private int i;

    public void method(){
        i=k+z;
    }

    /*Мы создаем класс Exercise6.Test, в котором имеется 3 переменные типа int.
    Также метод method(), в котором мы присваиваем переменной i знаение k+z.
     В main мы создаем объект t класса Exercise6.Test() и применяем метод metod() к этому объекту.
     Дальше мы выводим значение t в консоль присвоив ему значение переменной i.
     Компилятор выдает ошибку, так как переменная i имеет модификатор доступа private.

     Если System.out.println(t); то мы получаем ошибку NullPointerException. NPE появилась, потому что объкт t обращается по ссылке
      к методу method где i имеет null, так как мы не присваиваем ей никого значения.*/
}
