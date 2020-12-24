package com.Sabuin.ui;

import com.Sabuin.config.Config;
import com.Sabuin.generator.PasswordGenerator;
import com.Sabuin.util.ClipboardUtils;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

public class AppTray {

    private JFrame frame;

    public AppTray(JFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        try {
            Image icon = Window.ICON_IMAGE.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
            TrayIcon trayIcon = new TrayIcon(icon, "Password Vault");
            PopupMenu menu = new PopupMenu();
            Menu generator = new Menu("Password Generator");

            MenuItem showHide = new MenuItem("Show Window");
            showHide.addActionListener(a-> {
                frame.setVisible(true);
            });

            MenuItem passLength = new MenuItem("Password Length = " + Config.getConfig().getPassLength());
            passLength.addActionListener(a -> {
                String message = new StringBuilder().append("Enter new password length (")
                        .append(Config.PASSWORD_MIN_LENGTH).append('-').append(Config.PASSWORD_MAX_LENGTH)
                        .append(").").toString();
                String len = JOptionPane.showInputDialog(null, message,"Password length.",JOptionPane.INFORMATION_MESSAGE);
                if(len != null && Pattern.matches("([0-9]+)", len)){
                    Config.getConfig().setPassLength(Integer.parseInt(len));
                    passLength.setLabel("Password Length = " + Config.getConfig().getPassLength());
                }
            });

            CheckboxMenuItem useSymbols = new CheckboxMenuItem("Use Symbols", Config.getConfig().getUseSymbols());
            useSymbols.addItemListener(a -> Config.getConfig().setUseSymbols(useSymbols.getState()));

            MenuItem generatePass = new MenuItem("Generate Password");
            generatePass.addActionListener(a -> {
                    trayIcon.displayMessage("","Copied to Clipboard.",TrayIcon.MessageType.INFO);
                    ClipboardUtils.copyToClipboard(PasswordGenerator.generatePassword());
            });

            MenuItem exit = new MenuItem("Exit");
            exit.addActionListener(a -> {
                    Config.getConfig().save();
                    System.exit(0);
            });

            menu.add(showHide);
            menu.addSeparator();
            menu.add(generator);
            generator.add(passLength);
            generator.add(useSymbols);
            generator.addSeparator();
            generator.add(generatePass);
            menu.addSeparator();
            menu.add(exit);

            trayIcon.setPopupMenu(menu);
            SystemTray tray = SystemTray.getSystemTray();
            tray.add(trayIcon);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }


}
