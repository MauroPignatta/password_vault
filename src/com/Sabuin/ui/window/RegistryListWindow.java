package com.Sabuin.ui.window;

import com.Sabuin.entity.Registry;
import com.Sabuin.manager.RegistryManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegistryListWindow extends JFrame {

    private JLabel label;
    private JScrollPane spane;
    private JButton editButton;
    private JButton deleteButton;
    private JButton backButton;
    private JList list;
    private DefaultListModel model;

    private RegistryManager regManager;

    public RegistryListWindow() {
        list = new JList();
        model = createModel();
        list.setModel(model);

        regManager = new RegistryManager("Yagom011");

        spane = new JScrollPane();
        spane.getViewport().add(list);
        label = new JLabel();
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        backButton = new JButton("Back");

        initUI();
    }

    public JList getList() {
        return list;
    }

    public DefaultListModel getModel() {
        return model;
    }

    public RegistryManager getRegManager() {
        return regManager;
    }

    private void initUI() {
        setUndecorated(true);
        setLocationRelativeTo(null);

        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Registry registry = (Registry) list.getSelectedValue();
                if(registry != null){
                    label.setText(registry.toString());
                }else{
                    label.setText(" ");
                }
            }
        });

        createLayout(spane, label, editButton, deleteButton, backButton);
    }

    private void createLayout(JComponent... arg) {
        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
                .addComponent(arg[4])
        );
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
                .addComponent(arg[4])
        );
        pack();
    }

    private Registry[] getRegistries(){
        if(regManager.registriesSize() == 0){
            System.out.println("You have no registries yet.");
            return new Registry[0];
        }
        return regManager.getRegistries();
    }

    private DefaultListModel createModel(){

        Registry[] registries = getRegistries();

        DefaultListModel model = new DefaultListModel();

        for(Registry r : registries)
            model.addElement(r);

        return model;
    }

    public void addListeners(ActionListener actionListener){
        editButton.setActionCommand("edit");
        editButton.addActionListener(actionListener);
        deleteButton.setActionCommand("delete");
        deleteButton.addActionListener(actionListener);
        backButton.setActionCommand("back");
        backButton.addActionListener(actionListener);
    }
}