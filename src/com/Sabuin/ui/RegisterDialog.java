package com.Sabuin.ui;

import com.Sabuin.helper.ImageHelper;
import com.Sabuin.util.FrameDragListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class RegisterDialog extends JDialog {

    private final static int WIDTH = 500;
    private final static int HEIGHT = 500;
    private final static int BORDER_THICKNESS = 5;

    private ImageIcon icon = ImageHelper.openImageAsIcon("/logo.png");

    private JLabel labelIcon = new JLabel("logo");
    private JPanel panel = new JPanel();

    public RegisterDialog() {
        setTitle("Register Dialog");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setUndecorated(true); //removes title bar
        editElements();
        addElements();
//        addListeners();
        setVisible(true);
    }

    private void editElements(){
        editPanel();
        labelIcon.setIcon(icon);
        labelIcon.setBounds((WIDTH/2)-50-BORDER_THICKNESS,30,100,76);

    }
    private void editPanel(){
        setBackground(UIColor.BACKGROUND_NO_TRANSPARENT_COLOR);
        panel.setBackground(UIColor.BACKGROUND_NO_TRANSPARENT_COLOR);
        panel.setLayout(null);
        panel.setBorder(new LineBorder(UIColor.BACKGROUND_BORDER, BORDER_THICKNESS));
    }

    private void addElements(){
        add(panel);
        panel.add(labelIcon);

    }
}
