package com.Sabuin.ui.controller;

import com.Sabuin.factory.AccountFactory;
import com.Sabuin.manager.AccountManager;
import com.Sabuin.ui.component.Message;
import com.Sabuin.ui.window.LoginWindow;
import com.Sabuin.ui.window.MainWindow;
import com.Sabuin.ui.window.RegisterDialog;
import com.Sabuin.validator.AccountValidator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {

    private LoginWindow loginWindow;
    private AccountManager accountManager;
    private AccountValidator accountValidator;

    public LoginController(LoginWindow loginWindow) {
        this.loginWindow = loginWindow;
        this.loginWindow.addListeners(this);
        accountManager = new AccountManager(new AccountFactory());
        accountValidator = new AccountValidator();
    }

    public AccountManager getAccountManager(){
        return accountManager;
    }

    public AccountValidator getAccountValidator(){
        return accountValidator;
    }

    public void setVisible(boolean visibility){
        loginWindow.setVisible(visibility);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "login":
                String username = loginWindow.getUser();
                String password = loginWindow.getPassword();
//                if(accountValidator.validateUsername(username) && accountValidator.validatePassword(password)){
                    System.out.println(accountManager.login(username, password));
                    Message.show("                Login exitoso!");
                    loginWindow.dispose();

                    MainWindow mainWindow = new MainWindow();
                    MainController mainController = new MainController(mainWindow);
                    mainWindow.addListeners(mainController);
//                }else{
//                    Message.show("Alguno de los campos es incorrecto");
//                } LO COMENTE PARA NO TENER QUE LOGUEARME TOD0 EL TIEMPO VISTE
                break;
            case "close":
                loginWindow.setVisible(false);
                System.exit(0);
                break;
            case "register":
                loginWindow.setVisible(false);

                RegisterDialog registerDialog = new RegisterDialog();
                RegisterController registerController = new RegisterController(registerDialog,this);
                registerDialog.addListeners(registerController);
        }
    }
}
