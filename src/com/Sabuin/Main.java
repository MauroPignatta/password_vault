package com.Sabuin;

import com.Sabuin.enums.Theme;
import com.Sabuin.ui.UIAssets;
import com.Sabuin.ui.controller.LoginController;
import com.Sabuin.ui.window.LoginWindow;

public class Main {

    public static void main(String[] args) {
        UIAssets.init(Theme.LIGHT_BLACK);
        LoginWindow loginWindow = new LoginWindow();
        LoginController loginController = new LoginController(loginWindow);


    }

}
