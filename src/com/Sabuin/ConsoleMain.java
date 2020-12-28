package com.Sabuin;

import com.Sabuin.entity.Registry;
import com.Sabuin.factory.AccountFactory;
import com.Sabuin.factory.RegistryFactory;
import com.Sabuin.manager.AccountManager;
import com.Sabuin.manager.RegistryManager;
import com.Sabuin.util.ClipboardUtils;
import com.Sabuin.util.URLUtils;

import java.net.URL;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleMain {

    private static final String LOGIN = "1";
    private static final String REGISTER = "2";
    private static final String EXIT = "0";

    private static final String ADD = "1";
    private static final String FIND = "2";
    private static final String EDIT = "3";
    private static final String LIST = "4";

    private static final Scanner scanner = new Scanner(System.in);
    private static final AccountManager accManager = new AccountManager(new AccountFactory());
    private static RegistryManager regManager = null;

    public static void main(String[] args) {

        AppLock.init();
        if(AppLock.isLocked()){
            System.err.println("PasswordVault is already running.");
            System.exit(0);
        }

        boolean close = false;
        boolean logged = false;

        while(!close && !logged){
            printLoginMenu();
            String opt = getOption();

            switch (opt){
                case LOGIN:
                    logged = login();
                    break;
                case REGISTER:
                    register();
                    break;
                case EXIT:
                    close = true;
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }

        while(!close){
            printUserMenu();
            String opt = getOption();

            switch (opt){
                case ADD:
                    addRegistry();
                    break;
                case FIND:
                    Registry reg = findRegistry();
                    if(reg != null){
                        System.out.println(reg);
                        ClipboardUtils.copyToClipboard(reg.getAccount().getPassword());
                        System.out.println("Password copied to clipboard.");
                    }
                    break;
                case EDIT:
                    editRegistry();
                    regManager.saveRegistries();
                    break;
                case LIST:
                    listRegistries();
                    break;
                case EXIT:
                    close = true;
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }

    private static Registry findRegistry() {
        if(regManager.registriesSize() == 0){
            System.out.println("You have no registries yet.");
            return null;
        }

        System.out.println("Please enter registry ID: ");
        String intString = scanner.nextLine();
        if(!Pattern.matches("^([0-9]+)$", intString)){
            System.out.println("ID must be a positive number.");
            return null;
        }
        Registry reg = regManager.getRegistry(Integer.parseInt(intString));
        if(reg == null){
            System.out.println("No registry found with id: " + intString);
        }

        return reg;
    }

    private static void editRegistry() {
        Registry r = findRegistry();
        if(r == null)
            return;

        boolean keepGoing = false;
        while(!keepGoing){
            printEditMenu();
            String opt = getOption();

            switch (opt){
                case "1":
                    String oldName = r.getName();
                    System.out.print("Please enter new name: ");
                    r.setName(scanner.nextLine());
                    System.out.println("Replaced " + oldName + " to " + r.getName());
                    break;
                case "2":
                    URL oldURL = r.getUrl();
                    System.out.print("Please enter new URL: ");
                    r.setUrl(URLUtils.toURL(scanner.nextLine()));
                    System.out.println("Replaced " + oldURL + " to " + r.getUrl());
                    break;
                case "3":
                    String oldUsername = r.getAccount().getUsername();
                    System.out.print("Please enter new Username: ");
                    r.getAccount().setUsername(scanner.nextLine());
                    System.out.println("Replaced " + oldUsername + " to " + r.getAccount().getUsername());
                    break;
                case "4":
                    System.out.print("Please enter new Password: ");
                    r.getAccount().setPassword(scanner.nextLine());
                    System.out.println("Password has been replaced.");
                    break;
                case "5":
                    String oldDesc = r.getDescription();
                    System.out.print("Please enter new Description: ");
                    r.setDescription(scanner.nextLine());
                    System.out.println("Replaced " + oldDesc + " to " + r.getDescription());
                    break;
                case "0":
                    keepGoing = true;
                    break;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }


    }

    private static void listRegistries() {
        int id = 0;
        if(regManager.registriesSize() == 0){
            System.out.println("You have no registries yet.");
            return;
        }
        for(Registry r : regManager.getRegistries()){
            System.out.println("ID = " + (id++));
            System.out.println(r);
        }
    }

    private static void addRegistry() {
        RegistryFactory factory = new RegistryFactory();
        AccountFactory accountFactory = new AccountFactory();

        System.out.print("Enter a name for the registry: ");
        factory.setName(scanner.nextLine());

        System.out.print("Enter a URL for the registry (Optional): ");
        factory.setURL(URLUtils.toURL(scanner.nextLine()));

        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        factory.setAccount(accountFactory.createAccount(username, password));

        System.out.print("Add a description (Optional): ");
        factory.setDescription(scanner.nextLine());

        regManager.addRegistry(factory.build());
    }

    private static boolean login() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        
        boolean login = accManager.login(username, password);
        if(login){
            regManager = new RegistryManager(username);
            System.out.println("Login successful.");
        } else {
            System.out.println("Fail to login. Username or password is wrong.");
        }
        return login;
    }

    private static void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Repeat password: ");
        String repeatedPassword = scanner.nextLine();

        if(!password.equals(repeatedPassword)){
            System.out.println("Passwords don't match.");
            return;
        }

        boolean registered = accManager.createAccount(username, password);
        if(registered) {
            System.out.println("Your account has been created.");
        } else {
            System.out.println("Username already exists, please enter another username.");
        }

    }

    private static String getOption() {
        return scanner.nextLine();
    }

    private static void printLoginMenu() {
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("0. Exit");

        System.out.println("\nPlease select your option.");
    }

    private static void printUserMenu() {
        System.out.println("1. Add new registry.");
        System.out.println("2. Find registry.");
        System.out.println("3. Edit registry.");
        System.out.println("4. List registries.");
        System.out.println("0. Exit.");
    }

    private static void printEditMenu() {
        System.out.println("1. Edit Name");
        System.out.println("2. Edit URL");
        System.out.println("3. Edit Username");
        System.out.println("4. Edit Password");
        System.out.println("5. Edit Description");
        System.out.println("0. Back");
        System.out.println();
    }

}
