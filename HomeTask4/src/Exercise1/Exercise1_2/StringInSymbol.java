package Exercise1.Exercise1_2;

public class StringInSymbol {
    private String ourString;

    public StringInSymbol(String ourString){
        this.ourString = ourString;
    }

    public void setOurString(String ourString){
        this.ourString = ourString;
    }
    public String getOurString() {
        return ourString;
    }

    public void stringInSymbol(){
        for(int i=0; i<ourString.length();i++){
            char symbol = ourString.charAt(i);
            System.out.println(i + "-й символ: " + symbol);;
        }

    }
}
