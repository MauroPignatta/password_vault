package com.Sabuin.ui.component;

import com.Sabuin.ui.UIAssets;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Message extends JDialog{

    private final static int WIDTH = 300;
    private final static int HEIGHT = 100;
    private final static int BORDER_THICKNESS = 5;

    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private JButton button = new UIButton("", (WIDTH/2)-50-BORDER_THICKNESS,60,
            UIAssets.CLOSE_BUTTON_IMG, UIAssets.CLOSE_HOVER_BUTTON_IMG);

    private Message(String text) {
        setTitle("Message");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setUndecorated(true);
        editElements(text);
        addElements();
        setVisible(true);
    }

    public static void show(String text) {
        Message message = new Message(text);
    }

    private void editElements(String text){
        editPanel();
        label.setText(text);
        label.setBounds((WIDTH/2)-105,25,250,25);
        label.setForeground(UIAssets.TEXT_FIELD_SELECTION);
        button.addActionListener(e -> dispose());
    }
    private void editPanel(){
        setBackground(UIAssets.PANEL_BACKGROUND_NO_TRANSPARENCY);
        panel.setBackground(UIAssets.PANEL_BACKGROUND_NO_TRANSPARENCY);
        panel.setLayout(null);
        panel.setBorder(new LineBorder(UIAssets.PANEL_BACKGROUND_BORDER, BORDER_THICKNESS));
    }

    private void addElements(){
        add(panel);
        panel.add(label);
        panel.add(button);
    }
}
