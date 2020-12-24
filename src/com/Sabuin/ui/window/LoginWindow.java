package com.Sabuin.ui.window;

import com.Sabuin.factory.AccountFactory;
import com.Sabuin.manager.AccountManager;
import com.Sabuin.ui.AppTray;
import com.Sabuin.ui.UIAssets;
import com.Sabuin.ui.component.UIComponentManager;
import com.Sabuin.ui.component.UIButton;
import com.Sabuin.util.FrameDragListener;
import com.Sabuin.validator.AccountValidator;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;


public class LoginWindow extends JFrame {

    private final static String TITLE = "Password Vault";
    private final static int WIDTH = 300;
    private final static int HEIGHT = 300;
    private final static int BORDER_THICKNESS = 5;

    private ImageIcon icon = UIAssets.LOGO_IMG;

    private JLabel labelIcon = new JLabel("logo");
    private JPanel panel = new JPanel();
    private JTextField userTextField = new JTextField("User");
    private JTextField passwordTextField = new JPasswordField("Password");
    private JButton loginButton = new UIButton("login", (WIDTH/2)-50-BORDER_THICKNESS,185, UIAssets.LOGIN_BUTTON_IMG, UIAssets.LOGIN_HOVER_BUTTON_IMG);
    private JButton registerButton = new UIButton("register",(WIDTH/2)-50-BORDER_THICKNESS,211, UIAssets.REGISTER_BUTTON_IMG, UIAssets.REGISTER_HOVER_BUTTON_IMG);
    private JButton closeButton = new UIButton("close",(WIDTH/2)-50-BORDER_THICKNESS,237, UIAssets.CLOSE_BUTTON_IMG, UIAssets.CLOSE_HOVER_BUTTON_IMG);

    public String getUser(){
        return userTextField.getText();
    }

    public String getPassword(){
        return passwordTextField.getText();
    }

    AppTray appTray = new AppTray(this);

    public LoginWindow() {
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setUndecorated(true); //removes title bar
        makeDraggable();
        editElements();
        addElements();
        setVisible(true);
    }

    private void makeDraggable() {
        FrameDragListener frameDragListener = new FrameDragListener(this);
        addMouseListener(frameDragListener);
        addMouseMotionListener(frameDragListener);
    }

    private void editElements(){
        editPanel();
        labelIcon.setIcon(icon);
        labelIcon.setBounds((WIDTH/2)-50-BORDER_THICKNESS,30,100,76);

        userTextField.setBounds((WIDTH/2)-50-BORDER_THICKNESS,130,100,25);
        UIComponentManager.edit(userTextField);

        passwordTextField.setBounds((WIDTH/2)-50-BORDER_THICKNESS,156,100,25);
        UIComponentManager.edit(passwordTextField);
    }

    private void editPanel(){
        setBackground(UIAssets.PANEL_BACKGROUND);
        panel.setBackground(UIAssets.PANEL_BACKGROUND);
        panel.setLayout(null);
        panel.setBorder(new LineBorder(UIAssets.PANEL_BACKGROUND_BORDER, BORDER_THICKNESS));
    }

    private void addElements(){
        add(panel);
        panel.add(userTextField);
        panel.add(passwordTextField);
        panel.add(loginButton);
        panel.add(closeButton);
        panel.add(labelIcon);
        panel.add(registerButton);
    }

    public void addListeners(ActionListener actionListener){
        closeButton.addActionListener(actionListener);
        loginButton.addActionListener(actionListener);
        registerButton.addActionListener(actionListener);
    }

}
