package com.Sabuin.manager;

import com.Sabuin.config.Config;
import com.Sabuin.factory.AccountFactory;
import com.Sabuin.file.BinaryFile;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {

    private static final String filename = "data.psv";

    private Map<String, String> accounts;

    private BinaryFile accountFile;
    private AccountFactory factory;

    public AccountManager(AccountFactory factory) {
        this.factory = factory;
        accounts = new HashMap<>();

        openAccountFile();
        loadAccounts();
    }

    private void openAccountFile() {
        accountFile = new BinaryFile(filename);
    }

    private void loadAccounts() {
        String json = accountFile.toString().replaceAll("[{}\"]", "");
        String[] accountStrings = json.split(",");
        for(String s : accountStrings){
            String[] parsedString = s.split(":");
            accounts.put(parsedString[0], parsedString[1]);
        }

        System.out.println(accounts);
    }

    public boolean login(String username, String password){
        String savedPassword = accounts.get(username);
        return savedPassword != null && savedPassword.equals(password);
    }

    public boolean createAccount(String username, String password){
        if(accounts.containsKey(username))
            return false;

        accounts.put(username, password);

        return save();
    }

    private boolean save() {
        if(accountFile == null)
            return false;

        return accountFile.write(Config.getConfig().getGson().toJson(accounts, HashMap.class));
    }

}
