package com.Sabuin.ui.component;

import com.Sabuin.ui.UIAssets;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class UIComponentManager {

    public static void edit(JTextField jTextField){
        jTextField.setBackground(UIAssets.TEXT_FIELD_BACKGROUND);
        jTextField.setBorder(new LineBorder(UIAssets.TEXT_FIELD_BORDER));
        jTextField.setSelectionColor(UIAssets.TEXT_FIELD_SELECTION);
        jTextField.setSelectedTextColor(UIAssets.TEXT_FIELD_SELECTED_TEXT);
        jTextField.setCaretColor(UIAssets.TEXT_FIELD_CARET);
        jTextField.setForeground(UIAssets.TEXT_FIELD_FOREGROUND);
    }

    public static void edit(JButton button, Border border, ImageIcon imageIcon){
        button.setBorder(border);
        button.setIcon(imageIcon);
    }

    public static void addMouseListener(JButton button, Border border, ImageIcon hoverImage, ImageIcon image){
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                UIComponentManager.edit(button, border, hoverImage);
            }
            @Override
            public void mouseExited(MouseEvent e) { UIComponentManager.edit(button, border, image); }
        });
    }


}
