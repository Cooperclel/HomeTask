package exercise2;

import java.util.Arrays;

public class Exercise2 {
    public static void main(String[] args){
        ECountries belarus1 = ECountries.Belarus;
        ECountries belarus2 =  ECountries.valueOf("Belarus");

        System.out.println("Exercise 2.6");
        if(belarus1 == belarus2){
            System.out.println(true);
        }else System.out.println(false);

        System.out.println("\nExercise 2.7");
        try{
            ECountries notName = ECountries.valueOf("Lithuania");
        }catch (IllegalArgumentException e){
            System.out.println("Не верно задано имя Энума " + e.getMessage());
        }

        System.out.println("\nExercise 2.4 / 2.5");
        belarus1.countryAreaKM2();
        belarus1.numberOfPersonsMLN();
        belarus2.countryAreaKM2();
        belarus2.numberOfPersonsMLN();
    }
}
