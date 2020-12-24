package com.Sabuin.ui;

import com.Sabuin.config.Config;
import com.Sabuin.util.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window {

    public static Image ICON_IMAGE = ImageUtils.openImageFromResources("/icon/icon.png");

    public static Window window;

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private JFrame frame;
    private JPanel panel;
    private AppTray tray;

    private Window() {
        frame = new JFrame("Password Vault.");
        panel = new JPanel(null);
        tray = new AppTray(frame);
        init();
    }

    private void init() {

        Dimension panelDimension = new Dimension(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Config.getConfig().save();
                super.windowClosing(e);
            }
        });

        if(ICON_IMAGE != null)
            frame.setIconImage(ICON_IMAGE.getScaledInstance(32,32,Image.SCALE_SMOOTH));

        panel.setPreferredSize(panelDimension);
        frame.add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static Window getWindow(){
        if(window == null)
            window = new Window();

        return window;
    }

}
