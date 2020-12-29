package com.Sabuin.ui.controller;

import com.Sabuin.ui.window.MainWindow;
import com.Sabuin.ui.window.RegistryListWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener {

    private MainWindow mainWindow;

    public MainController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "close":
                System.exit(0);
                break;
            case "registryList":
                RegistryListWindow registryListWindow = new RegistryListWindow();
                RegistryListController registryListController = new RegistryListController(registryListWindow);
                registryListWindow.addListeners(registryListController);
                registryListWindow.setVisible(true);
                break;
        }
    }
}
