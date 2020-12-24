package com.Sabuin.ui.controller;

import com.Sabuin.manager.AccountManager;
import com.Sabuin.ui.window.RegisterDialog;
import com.Sabuin.validator.AccountValidator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController implements ActionListener {
    RegisterDialog registerDialog;
    LoginController loginController;

    public RegisterController(RegisterDialog registerDialog, LoginController loginController){
        this.registerDialog = registerDialog;
        this.loginController = loginController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "register":
                AccountValidator accountValidator = loginController.getAccountValidator();
                AccountManager accountManager = loginController.getAccountManager();
                String username = registerDialog.getUser();
                String password1 = registerDialog.getPassword();
                String password2 = registerDialog.getRepeatedPassword();
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
                break;
            case "back":
                loginController.setVisible(true);
                registerDialog.dispose();
                break;
        }



    }
}
