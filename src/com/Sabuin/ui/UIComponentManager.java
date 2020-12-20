package com.Sabuin.ui;

import com.Sabuin.helper.ImageHelper;
import com.Sabuin.ui.UIColor;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UIComponentManager {
    public static void edit(JTextField jTextField){
        jTextField.setBackground(UIColor.TEXT_FIELD_BACKGROUND);
        jTextField.setBorder(new LineBorder(UIColor.TEXT_FIELD_BORDER));
        jTextField.setSelectionColor(UIColor.TEXT_FIELD_SELECTION);
        jTextField.setSelectedTextColor(UIColor.TEXT_FIELD_SELECTED_TEXT);
        jTextField.setCaretColor(UIColor.TEXT_FIELD_CARET);
        jTextField.setForeground(UIColor.TEXT_FIELD_FOREGROUND);
    }

    public static void edit(JButton button, Border border, String imagePath){
        button.setBorder(border);
        button.setIcon(ImageHelper.openImageAsIcon(imagePath));
    }

    public static void addMouseListener(JButton button, Border border, String hoverImage, String image){
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
