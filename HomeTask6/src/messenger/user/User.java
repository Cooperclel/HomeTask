package messenger.user;

import messenger.message.InputTastatur;

public class User implements IUser{
    private String login;
    private String password;

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void checkUser(User user){
        String truePassword = user.getPassword();
        String inputPassword = null;
        do{
            System.out.println("User " + user.getLogin() + " введите пароль");
            inputPassword = InputTastatur.inputTastatur();
            if (!truePassword.equals(inputPassword)){
                System.out.println("Inwalid Password");
            }else System.out.println("True Password");

        }while (!truePassword.equals(inputPassword));
    }

    public String toString(){
        return "User: " + login;
    }


}