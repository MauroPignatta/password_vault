package com.Sabuin.manager;

import com.Sabuin.entity.Account;
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
        String[] stringAccounts = accountFile.toString().split(",");

        for(String account : stringAccounts){
            if(!account.equals("")){
                Account currentAccount = factory.createAccount(account);
                accounts.put(currentAccount.getUsername(), currentAccount.getPassword());
            }
        }
    }

    public boolean login(String username, String password){
        return accounts.get(username).equals(password);
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

        StringBuilder builder = new StringBuilder();
        int size = accounts.size() - 1;

        for(Map.Entry<String, String> entry : accounts.entrySet()){
            String separator = size-- > 0 ? "," : "";
            builder.append(factory.createAccount(entry.getKey(), entry.getValue())).append(separator);
        }

        return accountFile.write(builder.toString());
    }

}
