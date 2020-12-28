package com.Sabuin;

import com.Sabuin.enums.Theme;
import com.Sabuin.ui.UIAssets;
import com.Sabuin.ui.controller.LoginController;
import com.Sabuin.ui.window.LoginWindow;

public class Main  {

    public static void main(String[] args){

        AppLock.init();
        if(AppLock.isLocked()){
            System.err.println("PasswordVault is already running.");
            System.exit(0);
        }

        UIAssets.init(Theme.DARK_RED);
        LoginWindow loginWindow = new LoginWindow();
        LoginController loginController = new LoginController(loginWindow);
    }

}
