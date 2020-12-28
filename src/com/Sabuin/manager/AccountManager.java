package com.Sabuin.manager;

import com.Sabuin.config.Config;
import com.Sabuin.factory.AccountFactory;
import com.Sabuin.file.BinaryFile;
import com.Sabuin.log.Log;
import com.Sabuin.log.LogType;
import com.Sabuin.util.Base64Utils;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {

    private static final String filename = "data.psv";

    private Map accounts;

    private BinaryFile accountFile;
    private AccountFactory factory;

    public AccountManager(AccountFactory factory) {
        this.factory = factory;

        openAccountFile();
        loadAccounts();
    }

    private void openAccountFile() {
        accountFile = new BinaryFile(filename);
    }

    private void loadAccounts() {
        try{
            String fileContent = accountFile.read();
            if(!fileContent.isEmpty()){
                String json = Base64Utils.decode(fileContent);
                accounts = Config.getConfig().getGson().fromJson(json, Map.class);
            } else {
                accounts = new HashMap();
            }
        } catch (Exception e){
            System.err.println(new Log(LogType.ERROR,
                    "An error occurred trying to load " + accountFile.getPath()));
        }
    }

    public boolean login(String username, String password){
        String savedPassword = (String) accounts.get(username);
        return savedPassword != null && savedPassword.equals(password);
    }

    public boolean createAccount(String username, String password){
        if(accounts.containsKey(username))
            return false;

        accounts.put(username, password);

        return save();
    }

    private boolean save() {
        try{
            String accountsString = Base64Utils.encode(Config.getConfig().getGson().toJson(accounts, Map.class));
            accountFile.write(accountsString);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
