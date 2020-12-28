package com.Sabuin;

import com.Sabuin.entity.Account;
import com.Sabuin.enums.Theme;
import com.Sabuin.manager.RegistryManager;
import com.Sabuin.ui.UIAssets;
import com.Sabuin.ui.controller.LoginController;
import com.Sabuin.ui.window.LoginWindow;
import com.Sabuin.util.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UIAssets.init(Theme.DARK_RED);
        LoginWindow loginWindow = new LoginWindow();
        LoginController loginController = new LoginController(loginWindow);
    }

}
