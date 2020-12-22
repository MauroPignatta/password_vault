package com.Sabuin.ui;

import com.Sabuin.factory.AccountFactory;
import com.Sabuin.helper.ImageHelper;
import com.Sabuin.manager.AccountManager;
import com.Sabuin.util.FrameDragListener;
import com.Sabuin.validator.AccountValidator;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentListener;


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
    private JButton loginButton = new JButton();
    private JButton registerButton = new JButton();
    private JButton closeButton = new JButton();

    private AccountManager accountManager = new AccountManager(new AccountFactory());
    AppTray appTray = new AppTray(this);

    public LoginWindow() {
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setUndecorated(true); //removes title bar
        makeDraggable();
        editElements();
        addElements();
        addListeners();
        setVisible(true);
    }

    protected AccountManager getAccountManager(){
        return accountManager;
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

        loginButton.setBounds((WIDTH/2)-50-BORDER_THICKNESS,185,100,25);
        UIComponentManager.edit(loginButton, null, UIAssets.LOGIN_BUTTON_IMG);

        registerButton.setBounds((WIDTH/2)-50-BORDER_THICKNESS,211,100,25);
        UIComponentManager.edit(registerButton, null, UIAssets.REGISTER_BUTTON_IMG);

        closeButton.setBounds((WIDTH/2)-50-BORDER_THICKNESS,237,100,25);
        UIComponentManager.edit(closeButton, null,UIAssets.CLOSE_BUTTON_IMG);
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

    private void addListeners(){
        closeButton.addActionListener(e -> setVisible(false));

        loginButton.addActionListener(e -> {
            AccountValidator accountValidator = new AccountValidator();
            String username = userTextField.getText();
            String password = passwordTextField.getText();
            if(accountValidator.validateUsername(username) && accountValidator.validatePassword(password)){
                System.out.println(accountManager.login(username, password));
            }else{
                System.out.println("sos pelotudo");
            }
        });

        registerButton.addActionListener(e -> {
            RegisterDialog registerDialog = new RegisterDialog(this);
            setVisible(false);
        });

        UIComponentManager.addMouseListener(loginButton,null, UIAssets.LOGIN_HOVER_BUTTON_IMG, UIAssets.LOGIN_BUTTON_IMG);
        UIComponentManager.addMouseListener(registerButton,null,UIAssets.REGISTER_HOVER_BUTTON_IMG, UIAssets.REGISTER_BUTTON_IMG);
        UIComponentManager.addMouseListener(closeButton,null,UIAssets.CLOSE_HOVER_BUTTON_IMG, UIAssets.CLOSE_BUTTON_IMG);
    }

}
