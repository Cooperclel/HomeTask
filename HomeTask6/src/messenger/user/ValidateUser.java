package messenger.user;


import messenger.message.InputTastatur;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUser {
    private static boolean proofLogin(User user){
        String login = user.getLogin();
        Pattern pattern = Pattern.compile("(#|!|\\\\|^[0-9]|^[azAZ]|^.{0,4}$)");
        Matcher matcher = pattern.matcher(login);

        return !matcher.find();
    }

    private static boolean proofPasswort(User user){
        String passwort = user.getPassword();
        Pattern pattern = Pattern.compile("^([a-zA-Z].{8,15})$");
        Matcher matcher = pattern.matcher(passwort);
        return matcher.matches();
    }

    public static User getValidUser(){
        boolean flagLogin = false;
        boolean flagPasswort = false;
        User user = null;
        do{
            System.out.println("Введите логин:");
            String login = InputTastatur.inputTastatur();
            System.out.println("Введите пароль:");
            String passwort = InputTastatur.inputTastatur();
            user = new User(login,passwort);
            flagLogin = ValidateUser.proofLogin(user);
            flagPasswort = ValidateUser.proofPasswort(user);
            if(!flagLogin || !flagPasswort){
                System.out.println("Inwalid User");
            }else System.out.println("True User");
        }while(!flagLogin || !flagPasswort);
        System.out.println(user.toString() +  "\nhas password: " + user.getPassword());
        return user;
    }
}