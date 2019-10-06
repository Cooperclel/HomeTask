package ternary_operator;

public class IfOperator implements IIfOperator{
    private String a;

    public IfOperator(String a){
        this.a = a;
    }

    public IfOperator(){}

    public void setA(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }

    public void proofText(){
        if (a != null){
            System.out.println(a);
        }else System.out.println("Запишите что-нибудь в IfOperator");
    }
}