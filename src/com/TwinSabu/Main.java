package com.TwinSabu;

import com.TwinSabu.factory.AccountFactory;
import com.TwinSabu.manager.AccountManager;
import com.TwinSabu.ui.Window;

public class Main {

    public static void main(String[] args) {
        AccountFactory factory = new AccountFactory();
        AccountManager manager = new AccountManager(factory);

        Window window = Window.getWindow();
    }



}
