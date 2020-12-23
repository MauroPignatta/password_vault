package com.Sabuin.ui.window;

import com.Sabuin.helper.ImageHelper;
import com.Sabuin.manager.AccountManager;
import com.Sabuin.ui.UIAssets;
import com.Sabuin.ui.UIComponentManager;
import com.Sabuin.ui.window.LoginWindow;
import com.Sabuin.validator.AccountValidator;

import javax.swing.*;
import javax.swing.border.LineBorder;

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
    private JButton registerButton = new JButton();
    private JButton backButton = new JButton();

    AccountManager accountManager;
    LoginWindow parent;

    public RegisterDialog(LoginWindow parent) {
        this.parent = parent;
        accountManager = parent.getAccountManager();
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

        userTextField.setBounds((WIDTH/2)-50-BORDER_THICKNESS,130,100,25);
        UIComponentManager.edit(userTextField);

        passwordTextField1.setBounds((WIDTH/2)-50-BORDER_THICKNESS,156,100,25);
        UIComponentManager.edit(passwordTextField1);

        passwordTextField2.setBounds((WIDTH/2)-50-BORDER_THICKNESS,182,100,25);
        UIComponentManager.edit(passwordTextField2);

        registerButton.setBounds((WIDTH/2)-50-BORDER_THICKNESS,211,100,25);
        UIComponentManager.edit(registerButton, new LineBorder(UIAssets.PANEL_BACKGROUND_BORDER),UIAssets.REGISTER_BUTTON_IMG);

        backButton.setBounds((WIDTH/2)-50-BORDER_THICKNESS,237,100,25);
        UIComponentManager.edit(backButton, new LineBorder(UIAssets.PANEL_BACKGROUND_BORDER),UIAssets.BACK_BUTTON_IMG);

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

    private void addListeners() {
        backButton.addActionListener(e -> {
            parent.setVisible(true);
            dispose();
        });

        AccountValidator accountValidator = new AccountValidator();
        registerButton.addActionListener(e -> {
            String username = userTextField.getText();
            String password1 = passwordTextField1.getText();
            String password2 = passwordTextField1.getText();
            if(password1.equals(password2)){
                if(accountValidator.validateUsername(username) && accountValidator.validatePassword(password1)){
                    accountManager.createAccount(username, password1);
                    System.out.println("registrado :)");
                }else{
                    System.out.println("sos pelotudo pero cuando te registras");
                }
            }else{
                System.out.println("sos pelotudo contraseNIas no son iguales");
            }

        });
        UIComponentManager.addMouseListener(registerButton, new LineBorder(UIAssets.PANEL_BACKGROUND_BORDER), UIAssets.REGISTER_HOVER_BUTTON_IMG, UIAssets.REGISTER_BUTTON_IMG);
        UIComponentManager.addMouseListener(backButton, new LineBorder(UIAssets.PANEL_BACKGROUND_BORDER), UIAssets.BACK_HOVER_BUTTON_IMG, UIAssets.BACK_BUTTON_IMG);
    }
}
