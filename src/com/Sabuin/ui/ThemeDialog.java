package com.Sabuin.ui;

import com.Sabuin.helper.ImageHelper;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.ListUI;
import java.awt.*;

public class ThemeDialog extends JDialog {
    private final static int WIDTH = 300;
    private final static int HEIGHT = 300;
    private final static int BORDER_THICKNESS = 5;

    private ImageIcon icon = ImageHelper.openImageAsIcon("/logo.png");

    private JLabel labelIcon = new JLabel("logo");
    private JPanel panel = new JPanel();

    String [] themes ={"Dark Red", "Light Red", "Dark Red", "Light Red","Dark Red", "Light Red",
            "Dark Red", "Light Red","Dark Red", "Light Red", "Dark Red", "Light Red"};
    JList<String> jList = new JList<>(themes);

    JLabel selectedTheme = new JLabel();

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

        selectedTheme.setBounds((WIDTH/2)-35-BORDER_THICKNESS, HEIGHT-BORDER_THICKNESS-40, 70, 30);
        selectedTheme.setBackground(Color.RED);
        selectedTheme.setBorder(new LineBorder(Color.RED));
        selectedTheme.setForeground(Color.RED);



    }

    private void editJList() {
        jList.setBounds(BORDER_THICKNESS, 130, WIDTH-BORDER_THICKNESS*2,80);
        jList.setVisibleRowCount(4);
        jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        jList.setSelectionForeground(Color.YELLOW);
        jList.setSelectionBackground(Color.GREEN);
        jList.setBackground(Color.BLUE);
        jList.setForeground(Color.RED);
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
        panel.add(selectedTheme);
    }

    private void addListeners() {
        jList.addListSelectionListener(e -> selectedTheme.setText(jList.getSelectedValue()));

    }
}
