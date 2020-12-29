package com.Sabuin.ui.controller;

import com.Sabuin.ui.window.RegistryListWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistryListController implements ActionListener {

    RegistryListWindow registryListWindow;

    public RegistryListController(RegistryListWindow registryListWindow) {
        this.registryListWindow = registryListWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "delete":
                int selected = registryListWindow.getList().getSelectedIndex();
                registryListWindow.getModel().remove(selected);
                //registryListWindow.getRegManager().deleteRegistry(selected);
                break;
            case "back":
                registryListWindow.dispose();
                break;
            case "edit":

                break;
        }
    }
}
