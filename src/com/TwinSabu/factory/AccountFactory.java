package com.TwinSabu.factory;

import com.TwinSabu.entity.Account;

public class AccountFactory {

    public Account createAccount(String username, String password){
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);

        return account;
    }

    public Account createAccount(String stringAccount){
        Account account = new Account();
        String[] parsedAccount = stringAccount.split(";");
        account.setUsername(parsedAccount[0]);
        account.setPassword(parsedAccount[1]);

        return account;
    }



}
