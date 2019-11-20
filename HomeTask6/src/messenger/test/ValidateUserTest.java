package messenger.test;

import messenger.message.InputTastatur;
import messenger.user.User;
import messenger.user.ValidateUser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class ValidateUserTest {

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

    @org.junit.jupiter.api.Test
    @ParameterizedTest(name = "{index} -> passwort={0}")
    @ValueSource(strings = {"passwort1", "123PasswortMyOnly", "get", "Пароль123", "CoolPasswort","passwort!&"})
    public void getValidUserPasswort(String passwort){
        System.out.println("Проверка пароля");
        boolean flagLogin = false;
        boolean flagPasswort = false;
        User user = null;
        user = new User("SomePerson1",passwort);
        flagLogin = ValidateUserTest.proofLogin(user);
        flagPasswort = ValidateUserTest.proofPasswort(user);
        System.out.println(user.toString() +  "\nhas password: " + user.getPassword());
        if(!flagLogin || !flagPasswort){
            System.out.println("Inwalid User");
        }else System.out.println("True User");

    }

    @org.junit.jupiter.api.Test
    @ParameterizedTest(name = "{index} -> login={0}")
    @ValueSource(strings = {"login1", "123Login", "get", "gotLogin123!", "CoolLogin","Логин"})
    public void getValidUserLogin(String login){
        System.out.println("Проверка логина");
        boolean flagLogin = false;
        boolean flagPasswort = false;
        User user = null;
        user = new User(login,"passwort1");
        flagLogin = ValidateUserTest.proofLogin(user);
        flagPasswort = ValidateUserTest.proofPasswort(user);
        System.out.println(user.toString() +  "\nhas password: " + user.getPassword());
        if(!flagLogin || !flagPasswort){
            System.out.println("Inwalid User");
        }else System.out.println("True User");

    }
}