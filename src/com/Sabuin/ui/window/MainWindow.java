package com.Sabuin.ui.window;

import com.Sabuin.ui.UIAssets;
import com.Sabuin.ui.component.UIButton;
import com.Sabuin.util.TitleBarDragListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame{
    private final static String TITLE = "Password Vault";
    private final static int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2;
    private final static int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2;
    private final static int BORDER_THICKNESS = 5;

    private ImageIcon icon = UIAssets.LOGO_IMG;

    private JLabel labelIcon = new JLabel("logo");
    private JPanel titleBar = new JPanel();
    private JPanel panel = new JPanel();

    private JButton closeButton = new UIButton("close",(WIDTH/2)-50-BORDER_THICKNESS,237, UIAssets.CLOSE_BUTTON_IMG, UIAssets.CLOSE_HOVER_BUTTON_IMG);
    private JButton listButton = new UIButton("registryList", (WIDTH/2)-50-BORDER_THICKNESS,237, UIAssets.LOGIN_BUTTON_IMG, UIAssets.LOGIN_HOVER_BUTTON_IMG);

    public MainWindow() {
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setUndecorated(true);
        makeDraggable();
        editElements();
        addElements();
        setVisible(true);
    }

    private void makeDraggable() {
//        ComponentResizer cr = new ComponentResizer();
//        cr.registerComponent(this);
//        cr.setSnapSize(new Dimension(10,10));
//        cr.setMinimumSize(new Dimension(WIDTH/5,HEIGHT/5));
//        cr.setMaximumSize(new Dimension(WIDTH,HEIGHT));
        TitleBarDragListener panelDragListener = new TitleBarDragListener(titleBar, this);
    }

    private void editElements(){
        editPanel();
        labelIcon.setIcon(icon);
        labelIcon.setBounds((WIDTH/2)-50-BORDER_THICKNESS,30,100,76);
    }

    private void editPanel(){
        setBackground(UIAssets.PANEL_BACKGROUND);

        titleBar.setBackground(UIAssets.PANEL_BACKGROUND);
        titleBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
        titleBar.setBorder(new LineBorder(UIAssets.PANEL_BACKGROUND_BORDER, BORDER_THICKNESS));

        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        panel.setBorder(new LineBorder(Color.YELLOW, BORDER_THICKNESS));
    }

    private void addElements(){
        add(titleBar, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        panel.add(labelIcon);
        panel.add(listButton);
        titleBar.add(closeButton);
    }

    public void addListeners(ActionListener actionListener){
        closeButton.addActionListener(actionListener);
        listButton.addActionListener(actionListener);
    }

}
