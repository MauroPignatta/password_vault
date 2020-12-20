package com.Sabuin.ui;

import com.Sabuin.helper.ImageHelper;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ThemeDialog extends JDialog {
    private final static int WIDTH = 300;
    private final static int HEIGHT = 300;
    private final static int BORDER_THICKNESS = 5;

    private ImageIcon icon = ImageHelper.openImageAsIcon("/logo.png");

    private JLabel labelIcon = new JLabel("logo");
    private JPanel panel = new JPanel();




    public ThemeDialog() {
        setTitle("Register Dialog");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setUndecorated(true);

        String [] themes ={"Dark Red", "Light Red"};
        JList<String> jList = new JList<>(themes);


        jList.setVisibleRowCount(1);
//        jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//        jList.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        JScrollPane jScrollPane = new JScrollPane(jList);
        panel.add(jScrollPane);

        editElements();
        addElements();
        addListeners();
        setVisible(true);
    }

    private void editElements(){
        editPanel();
        labelIcon.setIcon(icon);
        labelIcon.setBounds((WIDTH/2)-50-BORDER_THICKNESS,30,100,76);

//        jRadioButton.setBounds((WIDTH/2)-50-BORDER_THICKNESS, 120, 100,30);
//        jRadioButton.setBackground(UIAssets.TEXT_FIELD_BACKGROUND);
//        jRadioButton.setBorder(new LineBorder(UIAssets.TEXT_FIELD_BORDER));
//        jRadioButton.setForeground(UIAssets.TEXT_FIELD_FOREGROUND);
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

    }

    private void addListeners() {

    }
}
