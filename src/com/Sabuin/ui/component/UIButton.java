package com.Sabuin.ui.component;

import javax.swing.*;

public class UIButton extends JButton {

    public UIButton(int x, int y, ImageIcon buttonImage, ImageIcon buttonHoverImage) {
        setBounds(x,y,100,25);
        UIComponentManager.edit(this, null, buttonImage);
        UIComponentManager.addMouseListener(this,null, buttonHoverImage, buttonImage);
    }
}
