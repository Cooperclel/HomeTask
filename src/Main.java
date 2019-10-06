import dto.*;
import equation.Equations;
import equation.IEquations;
import exercise6.Test;
import logical_operators.BitwiseOperators;
import logical_operators.IBitwiseOpertors;
import logical_operators.IOperators;
import logical_operators.LogicalOperators;
import ternary_operator.IIfOperator;
import ternary_operator.IfOperator;
import operations.*;

public class Main {

    public static void main(String[] args) {

//////////////// Задание 1 //////////////////////////////////////////
        IShift i1 = new ShiftInteger(10,1);
        IShift i2 = new ShiftInteger(10,1);
        IShift i3 = new ShiftInteger(10,1);

        IShift mi1 = new ShiftNegativeNumber(-1,2);
        IShift mi2 = new ShiftNegativeNumber(-1,2);
        IShift mi3 = new ShiftNegativeNumber(-1,2);
////////////////Задание 2/////////////////////////////////////////////////
        IOperators lo1 = new LogicalOperators(true,true);
        IOperators lo2 = new LogicalOperators(true,false);

        IBitwiseOpertors b01 = new BitwiseOperators(29,30);
        IBitwiseOpertors b02 = new BitwiseOperators(29,30);
        IBitwiseOpertors b03 = new BitwiseOperators(29,30);

        ////////////////Задание 3///////////////////////////////////////
        IIfOperator ifp = new IfOperator("irir");

/////////////////Задание 4///////////////////////
        IComputer c1 = new AsusComputer(new Ram(10), new Hdd(1008));
        IComputer c2 = new AsusComputer(new Ram(10), new Hdd(2008));
        IComputer c3 = new AcerComputer(new Ram(10), new Hdd(3002));

////////////////Задание 5////////////////////
        IEquations eq1 = new Equations();
        IEquations eq2 = new Equations();
        IEquations eq3 = new Equations();
        IEquations eq4 = new Equations();
        IEquations eq5 = new Equations();
        IEquations eq6 = new Equations();
        IEquations eq7 = new Equations();
        IEquations eq8 = new Equations();
        IEquations eq9 = new Equations();

/////////////Задание 6////////////////////////////////////////

        Test t =new Test();
////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////




        System.out.println("Задание 1:");
        System.out.println("");
/////////////Задние 1////////////////////////////
        i1.shiftRight();
        i2.shiftLeft();
        i3.shiftFillingRight();

        System.out.println("Задание 2:");
        System.out.println("");
/////////////Задание 2///////////////////////////////
        mi1.shiftRight();
        mi2.shiftLeft();
        mi3.shiftFillingRight();

        System.out.println("Задание 3:");
        System.out.println("");
/////////////////Задание 3//////////////

        ifp.proofText();

        System.out.println("Задание 4:");
        System.out.println("");
/////////////Задание 4///////////////////
        boolean proof;
        proof = c3 instanceof AcerComputer;
        if (proof == true){
            System.out.println("Это AcerComputer");
        } else {
            System.out.println("ClassCastException");
        }

        System.out.println("Задание 5:");
        System.out.println("");
///////////////Задание 5//////////////////////////

        eq1.equation1(6);
        eq2.equation2(0);
        eq3.equation3(0);
        eq4.equation4(1);
        eq5.equation5(0);
        eq6.equation6(1);
        //eq7.equation7(0);
        eq8.equation8(false);
        eq9.equation9(false);

        System.out.println("Задание 6");
        System.out.println("");
/////////////Задание 6/////////////////
        t.method();
        //System.out.println(t.i);



    }
}

