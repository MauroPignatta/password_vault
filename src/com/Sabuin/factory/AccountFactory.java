package com.Sabuin.factory;

import com.Sabuin.config.Config;
import com.Sabuin.entity.Account;

public class AccountFactory {

    public Account createAccount(String username, String password){
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);

        return account;
    }

    public Account createAccount(String json){
        return Config.getConfig().getGson().fromJson(json, Account.class);
    }



}
