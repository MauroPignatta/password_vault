package com.Sabuin;

import com.Sabuin.enums.Theme;
import com.Sabuin.ui.ThemeDialog;
import com.Sabuin.ui.UIAssets;

public class Main {

    public static void main(String[] args) {
        UIAssets.init(Theme.DARK_RED);
        ThemeDialog themeDialog = new ThemeDialog();
    }


}
