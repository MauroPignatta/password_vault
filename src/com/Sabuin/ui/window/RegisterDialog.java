package com.Sabuin.ui.window;

import com.Sabuin.helper.ImageHelper;
import com.Sabuin.manager.AccountManager;
import com.Sabuin.ui.UIAssets;
import com.Sabuin.ui.component.UIButton;
import com.Sabuin.ui.component.UIComponentManager;
import com.Sabuin.validator.AccountValidator;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;

public class RegisterDialog extends JDialog {

    private final static int WIDTH = 300;
    private final static int HEIGHT = 300;
    private final static int BORDER_THICKNESS = 5;

    private ImageIcon icon = ImageHelper.openImageAsIcon("/logo.png");

    private JLabel labelIcon = new JLabel("logo");
    private JPanel panel = new JPanel();
    private JTextField userTextField = new JTextField("User");
    private JTextField passwordTextField1 = new JPasswordField("Password");
    private JTextField passwordTextField2 = new JPasswordField("Password");
    private JButton registerButton = new UIButton("register", (WIDTH/2)-50-BORDER_THICKNESS,211, UIAssets.REGISTER_HOVER_BUTTON_IMG, UIAssets.REGISTER_BUTTON_IMG);
    private JButton backButton = new UIButton("back", (WIDTH/2)-50-BORDER_THICKNESS,237,UIAssets.BACK_HOVER_BUTTON_IMG, UIAssets.BACK_BUTTON_IMG);

    public RegisterDialog() {
        setTitle("Register Dialog");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setUndecorated(true);
        editElements();
        addElements();
        setVisible(true);
    }

    public String getUser(){
        return userTextField.getText();
    }

    public String getPassword(){
        return passwordTextField1.getText();
    }

    public String getRepeatedPassword(){
        return  passwordTextField2.getText();
    }

    private void editElements(){
        editPanel();
        labelIcon.setIcon(icon);
        labelIcon.setBounds((WIDTH/2)-50-BORDER_THICKNESS,30,100,76);

        userTextField.setBounds((WIDTH/2)-50-BORDER_THICKNESS,130,100,25);
        UIComponentManager.edit(userTextField);

        passwordTextField1.setBounds((WIDTH/2)-50-BORDER_THICKNESS,156,100,25);
        UIComponentManager.edit(passwordTextField1);

        passwordTextField2.setBounds((WIDTH/2)-50-BORDER_THICKNESS,182,100,25);
        UIComponentManager.edit(passwordTextField2);

    }
    private void editPanel(){
        setBackground(UIAssets.PANEL_BACKGROUND_NO_TRANSPARENCY);
        panel.setBackground(UIAssets.PANEL_BACKGROUND_NO_TRANSPARENCY);
        panel.setLayout(null);
        panel.setBorder(new LineBorder(UIAssets.PANEL_BACKGROUND_BORDER, BORDER_THICKNESS));
    }

    private void addElements(){
        add(panel);
        panel.add(labelIcon);
        panel.add(userTextField);
        panel.add(passwordTextField1);
        panel.add(passwordTextField2);
        panel.add(registerButton);
        panel.add(backButton);
    }

    public void addListeners(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
        registerButton.addActionListener(actionListener);
    }
}
