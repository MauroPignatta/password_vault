package com.Sabuin.ui.controller;

import com.Sabuin.entity.Account;
import com.Sabuin.entity.Registry;
import com.Sabuin.factory.RegistryFactory;
import com.Sabuin.ui.window.RegistryListWindow;
import com.Sabuin.util.URLUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class RegistryListController implements ActionListener {

    RegistryListWindow registryListWindow;

    public RegistryListController(RegistryListWindow registryListWindow) {
        this.registryListWindow = registryListWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "add":
                Registry registry = new Registry();
                registry.setAccount(new Account());
                registry.setDescription("C");
                registry.setUrl(URLUtils.toURL("c.com"));
                registry.setName("ce");
                registryListWindow.getRegManager().addRegistry(registry);
                registryListWindow.getModel().addElement(registry);
                break;
            case "delete":
                int selected = registryListWindow.getList().getSelectedIndex();
                if(selected != -1){
                    registryListWindow.getModel().remove(selected);
                    registryListWindow.getRegManager().deleteRegistry(selected);
                }
                break;
            case "back":
                registryListWindow.dispose();
                break;
            case "edit":
                break;
        }
    }
}
