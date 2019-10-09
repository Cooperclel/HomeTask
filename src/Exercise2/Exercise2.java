package Exercise2;

public class Exercise2 {
    public static void main (String args[]){
        ILogicalOperators lo1 = new LogicalOperators(true,true);

        IBitwiseOpertors b01 = new BitwiseOperators(29,30);

        lo1.logicalAND();
        lo1.logicalOR();

        b01.bitwiseAND();
        b01.bitwiseOR();
        b01.bitwiseXOR();



    }
}
