package com.Sabuin.ui.window;

import com.Sabuin.entity.Registry;
import com.Sabuin.manager.RegistryManager;
import com.Sabuin.ui.UIAssets;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegistryListWindow extends JFrame {

    private final static String TITLE = "Password Vault";
    private final static int WIDTH = 600;
    private final static int HEIGHT = 600;
    private static int BORDER_THICKNESS = 5;

    private JLabel label;
    private JScrollPane spane;
    private JButton editButton;
    private JButton addButton;
    private JButton deleteButton;
    private JButton backButton;
    private JList list;
    private DefaultListModel model;

    private RegistryManager regManager;

    public RegistryListWindow() {
        regManager = new RegistryManager("Yagom011");

        list = new JList();
        model = createModel();
        list.setModel(model);

        spane = new JScrollPane();
        spane.getViewport().add(list);
        label = new JLabel();
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        backButton = new JButton("Back");
        addButton = new JButton("Add");

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
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setUndecorated(true);
        createPanel(new JPanel());
        setVisible(true);
    }
    private void createPanel(JPanel panel){
        add(panel);
        setBackground(UIAssets.PANEL_BACKGROUND);
        panel.setBackground(UIAssets.PANEL_BACKGROUND);
        panel.setLayout(null);
        panel.setBorder(new LineBorder(UIAssets.PANEL_BACKGROUND_BORDER, BORDER_THICKNESS));
        editElements();
        addElements(panel);
    }

    private void editElements() {
        spane.setBounds(BORDER_THICKNESS*3, BORDER_THICKNESS*3, WIDTH-(BORDER_THICKNESS*6),100);
        label.setBounds((WIDTH/2)-50-BORDER_THICKNESS, 130,200,50);
        addButton.setBounds(95,180,100,25);
        editButton.setBounds(200,180,100,25);
        deleteButton.setBounds(305,180,100,25);
        backButton.setBounds(410,180,100,25);
    }

    private void addElements(JPanel panel){
        panel.add(spane);
        panel.add(label);
        panel.add(addButton);
        panel.add(editButton);
        panel.add(deleteButton);
        panel.add(backButton);
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
        addButton.setActionCommand("add");
        addButton.addActionListener(actionListener);
        editButton.setActionCommand("edit");
        editButton.addActionListener(actionListener);
        deleteButton.setActionCommand("delete");
        deleteButton.addActionListener(actionListener);
        backButton.setActionCommand("back");
        backButton.addActionListener(actionListener);
    }
}