package com.TwinSabu.manager;

import com.TwinSabu.config.Config;
import com.TwinSabu.entity.Account;
import com.TwinSabu.factory.AccountFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class AccountManager {

    private static final String filename = "data.psv";

    private Map<String, String> accounts;

    private File accountFile;
    private AccountFactory factory;

    public AccountManager(AccountFactory factory) {
        this.factory = factory;
        accounts = new HashMap<>();

        openAccountFile();
        loadAccounts();
    }

    private void openAccountFile() {
        accountFile = new File(Config.getConfig().getHomePath() + "/" + filename);

        try {
            accountFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadAccounts() {
        try {
            FileInputStream fileInputStream = new FileInputStream(accountFile);

            byte[] bytes = new byte[4096];
            StringBuilder builder = new StringBuilder();

            while(fileInputStream.read(bytes) > 0){
                builder.append(new String(bytes));
            }

            String[] stringAccounts = builder.toString().split(",");

            for(String account : stringAccounts){
                if(!account.equals("")){
                    Account currentAccount = factory.createAccount(account);
                    accounts.put(currentAccount.getUsername(), currentAccount.getPassword());
                }
            }

            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
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
        boolean saved = false;

        if(accountFile == null)
            return false;

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(accountFile);
            StringBuilder builder = new StringBuilder();
            int size = accounts.size() - 1;

            for(Map.Entry<String, String> entry : accounts.entrySet()){
                String separator = size-- > 0 ? "," : "";
                builder.append(factory.createAccount(entry.getKey(), entry.getValue())).append(separator);
            }

            fileOutputStream.write(builder.toString().getBytes(StandardCharsets.UTF_8));
            saved = true;

            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return saved;
    }

}
