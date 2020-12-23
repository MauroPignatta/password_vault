package com.Sabuin;

import com.Sabuin.enums.Theme;
import com.Sabuin.ui.window.ThemeDialog;
import com.Sabuin.ui.UIAssets;

public class Main {

    public static void main(String[] args) {
        UIAssets.init(Theme.LIGHT_BLACK);
        ThemeDialog themeDialog = new ThemeDialog();
    }

}
