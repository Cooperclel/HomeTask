package exercise2;

public enum ECountries implements ICountries{
    Belarus(207_595, 9.508),
    Germany(357_386, 82.79),
    England(130_395, 63.182),
    Russia(17_100_000,144.5),
    Spain(505_990,46.72),
    USA(9_803_000, 308.746),
    Kazakhstan(2_725_000, 18.04),
    China(9_587_000,1386),
    Japan(377_973, 126.8),
    India(3_287_000, 1339);

    private int area;
    private double number;


    ECountries(int area, double number){
        this.area = area;
        this.number = number;
    }


    public void countryAreaKM2(){
        System.out.println("Площадь равна " + area + " км^2");
    }
    public void numberOfPersonsMLN(){
        System.out.println("Количесвто человек равно " + number + " млн человек");
    }
}
