package com.Sabuin.ui.component;

import javax.swing.*;
import java.awt.*;

public class ListEx extends JFrame {

    private JLabel label;
    private JScrollPane spane;
    private JButton editButton;
    private JButton deleteButton;
    private JButton backButton;

    public ListEx() {
        initUI();
    }

    private void initUI() {
        setUndecorated(true);

        DefaultListModel<String> model = new DefaultListModel();
        JList list = new JList(model);
        for(int i = 0; i<20; i++){
            model.addElement(String.valueOf(i));
        }

        spane = new JScrollPane();
        spane.getViewport().add(list);
        label = new JLabel();
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        backButton = new JButton("Back");

        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String name = (String) list.getSelectedValue();
                label.setText(name);
            }
        });
        editButton.addActionListener(e -> {

        });
        deleteButton.addActionListener(e -> {
            int selected = list.getSelectedIndex();
            if(selected != -1)
                model.removeElementAt(selected);
        });
        backButton.addActionListener(e -> {
            dispose();
        });

        createLayout(spane, label, editButton, deleteButton, backButton);

        setTitle("JList");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
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
}