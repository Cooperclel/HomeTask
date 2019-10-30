package messenger;

import jdk.jshell.execution.JdiExecutionControl;
import messenger.encryption.Decryption;
import messenger.encryption.Encryption;
import messenger.history.ConsoleSaver;
import messenger.history.IHistorySaver;
import messenger.message.*;
import messenger.user.*;

import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Messanger {
    public static void main(String[] args){

        PrintStream console = System.out;
        IHistorySaver consoleList = new ConsoleSaver(console);

        System.out.println("Создаем User1");
        User user1 = ValidateUser.getValidUser();
        System.out.println("Создаем User2");
        User user2 = ValidateUser.getValidUser();

        Dialogs dialogs = new Dialogs();

        String command = null;
        do{
            consoleList.commandList();
            command = ConsoleSaver.correctCommand();

            if (command.equals("1")){
                String commandDialog = null;
                String key = Encryption.keyCreation();

                do {
                    consoleList.commandListDialog();
                    commandDialog = ConsoleSaver.correctCommand();

                    if (commandDialog.equals("1")) {
                        user1.checkUser(user1);
                        user2.checkUser(user2);
                        consoleList.commandListMessage();
                        String commandMessage = null;

                        do {
                            commandMessage = ConsoleSaver.correctCommand();

                            if (commandMessage.equals("1")) {
                                boolean p = false;

                                do {
                                    System.out.println("Укажете пользователя, который пишет сообщение:");
                                    System.out.println("1) " + user1.toString());
                                    System.out.println("2) " + user2.toString());
                                    String choiseUser = InputTastatur.inputTastatur();

                                    if (choiseUser.equals("1") || choiseUser.equalsIgnoreCase("user1") || choiseUser.equals(user1.getLogin())) {
                                        Message message = new Message(user1);
                                        String encryptionMessage = Encryption.encryption(message.getMessage(), key);
                                        message.setMessage(encryptionMessage);
                                        dialogs.addMessages(message);
                                        System.out.println("Сообщение доставлено");
                                        p = true;
                                    }

                                    if (choiseUser.equals("2") || choiseUser.equalsIgnoreCase("user2") || choiseUser.equals(user2.getLogin())) {
                                        Message message = new Message(user2);
                                        String encryptionMessage = Encryption.encryption(message.getMessage(), key);
                                        message.setMessage(encryptionMessage);
                                        dialogs.addMessages(message);
                                        System.out.println("Сообщение доставлено");
                                        p = true;
                                    }

                                    if (p = false) {
                                        System.out.println("Invalid Command");
                                    }

                                } while (p = false);

                            }

                            if (commandMessage.equals("2")) {
                                boolean p = false;

                                do {
                                    System.out.println("Укажете пользователя, который пишет сообщение:");
                                    System.out.println("1) " + user1.toString());
                                    System.out.println("2) " + user1.toString());
                                    String choiseUser = InputTastatur.inputTastatur();

                                    if (choiseUser.equals("1") || choiseUser.equals(user1.getLogin())) {
                                        Message message = new Message(user1);
                                        Message.pauseInMessage(message);
                                        String encryptionMessage = Encryption.encryption(message.getMessage(), key);
                                        message.setMessage(encryptionMessage);
                                        dialogs.addMessages(message);
                                        System.out.println("Сообщение доставлено");
                                        p = true;
                                    }

                                    if (choiseUser.equals("2") || choiseUser.equals(user2.getLogin())) {
                                        Message message = new Message(user2);
                                        Message.pauseInMessage(message);
                                        String encryptionMessage = Encryption.encryption(message.getMessage(), key);
                                        message.setMessage(encryptionMessage);
                                        dialogs.addMessages(message);
                                        System.out.println("Сообщение доставлено");
                                        p = true;
                                    }

                                    if (p = false) {
                                        System.out.println("Invalid Command");
                                    }

                                } while (p = false);

                            }
                            consoleList.commandListMessage();

                        } while (!commandMessage.equals("3"));

                    }

                    dialogs.sortDialog();

                    if (commandDialog.equals("2")) {
                        System.out.println(dialogs.toString());
                    }

                    if (commandDialog.equals("3")) {
                        Dialogs decryptionDialog = Dialogs.toStringDecryption(dialogs);
                        System.out.println(decryptionDialog.toString());
                        for (int i = 0; i < dialogs.getMessages().length; i++) {
                            String encryptionMessage = Encryption.encryption(dialogs.getMessages()[i].getMessage(),key);
                            dialogs.getMessages()[i].setMessage(encryptionMessage);
                        }
                    }

                    if (commandDialog.equals("4")) {
                        Dialogs decryptionDialog = Dialogs.toStringDecryption(dialogs);
                        System.out.println(decryptionDialog.toString());
                        Message.fixMessage(decryptionDialog, key);
                        for (int i = 0; i < decryptionDialog.getMessages().length; i++) {
                            String encryptionMessage = Encryption.encryption(decryptionDialog.getMessages()[i].getMessage(),key);
                            dialogs.getMessages()[i].setMessage(encryptionMessage);
                        }

                    }

                }while (!commandDialog.equals("5"));

            }

        }while(!command.equals("2"));


    }
}
