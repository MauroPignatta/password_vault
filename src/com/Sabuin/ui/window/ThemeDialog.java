package com.Sabuin.ui.window;

import com.Sabuin.enums.Theme;
import com.Sabuin.util.ImageUtils;
import com.Sabuin.ui.UIAssets;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ThemeDialog extends JDialog {
    private final static int WIDTH = 300;
    private final static int HEIGHT = 300;
    private final static int BORDER_THICKNESS = 5;

    private ImageIcon icon = ImageUtils.openImageFromResourcesAsIcon("/logo.png");

    private JLabel labelIcon = new JLabel("logo");
    private JPanel panel = new JPanel();
    private JButton okButton = new JButton("OK");

    Theme [] themes ={Theme.DARK_RED, Theme.LIGHT_RED, Theme.LIGHT_BLACK};
    JList<Theme> jList = new JList<>(themes);


    public ThemeDialog() {
        setTitle("Register Dialog");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setUndecorated(true);
        editElements();
        addElements();
        addListeners();
        setVisible(true);
    }

    private void editElements(){
        editPanel();

        labelIcon.setIcon(icon);
        labelIcon.setBounds((WIDTH/2)-50-BORDER_THICKNESS,30,100,76);

        editJList();

        okButton.setBounds((WIDTH/2)-20-BORDER_THICKNESS, HEIGHT-40-BORDER_THICKNESS, 40,30);
        okButton.setBackground(UIAssets.TEXT_FIELD_BACKGROUND);
        okButton.setBorder(new LineBorder(UIAssets.PANEL_BACKGROUND_BORDER));
        okButton.setForeground(UIAssets.TEXT_FIELD_FOREGROUND);

    }

    private void editJList() {
        jList.setVisibleRowCount(4);
        jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jList.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        jList.setBounds(BORDER_THICKNESS*4, 130, WIDTH-BORDER_THICKNESS*8,80);
        jList.setSelectionForeground(Color.YELLOW);
        jList.setSelectionBackground(Color.GREEN);
        jList.setBorder(new LineBorder(UIAssets.PANEL_BACKGROUND_BORDER));
        jList.setBackground(UIAssets.PANEL_BACKGROUND_NO_TRANSPARENCY);
        jList.setForeground(UIAssets.PANEL_BACKGROUND_BORDER);
    }


    private void editPanel(){
        setBackground(UIAssets.PANEL_BACKGROUND);
        panel.setBackground(UIAssets.PANEL_BACKGROUND);
        panel.setLayout(null);
        panel.setBorder(new LineBorder(UIAssets.PANEL_BACKGROUND_BORDER, BORDER_THICKNESS));
    }

    private void addElements(){
        add(panel);
        panel.add(labelIcon);
        panel.add(jList);
        panel.add(okButton);
    }

    private void addListeners() {
        jList.addListSelectionListener(e -> {
            UIAssets.init(jList.getSelectedValue());
            this.dispose();
            ThemeDialog themeDialog = new ThemeDialog();
        });
        okButton.addActionListener(e -> {
            this.dispose();
            LoginWindow loginWindow = new LoginWindow();
        });
    }
}
