package com.Sabuin;

import com.Sabuin.enums.Theme;
import com.Sabuin.ui.LoginWindow;
import com.Sabuin.ui.UIAssets;

public class Main {

    public static void main(String[] args) {
        UIAssets.init(Theme.LIGHT_RED);
        LoginWindow loginWindow = new LoginWindow();
    }


}
