package com.Sabuin;

import com.Sabuin.factory.AccountFactory;
import com.Sabuin.manager.AccountManager;

public class Main {

    public static void main(String[] args) {

        AccountFactory factory = new AccountFactory();
        AccountManager manager = new AccountManager(factory);


    }

}
