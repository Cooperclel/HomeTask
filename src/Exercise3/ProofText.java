package Exercise3;

public class ProofText implements IProofText {
    private int k;
    private int b;

    public ProofText(int k, int b){
        this.k = k;
        this.b = b;
    }



    public void ifOperator(){
        if (k>b){
            System.out.println(k + " больше чем " + b);
        }else System.out.println(b + " больше чем " + k);
    }

    public void ternaryOperator(){
        //k>b? System.out.println(k + "больше чем " + b) : System.out.println(k + " больше чем " + b);
    }
}
