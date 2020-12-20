package com.Sabuin.ui;

import com.Sabuin.helper.ImageHelper;
import com.Sabuin.util.FrameDragListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LoginWindow extends JFrame {

    private final static String TITLE = "Password Vault";
    private final static int WIDTH = 300;
    private final static int HEIGHT = 300;
    private final static int BORDER_THICKNESS = 5;


    private ImageIcon icon = ImageHelper.openImageAsIcon("/logo.png");

    private JLabel labelIcon = new JLabel("logo");
    private JPanel panel = new JPanel();
    private JTextField userTextField = new JTextField("User");
    private JTextField passwordTextField = new JPasswordField("Password");
    private JButton loginButton = new JButton();
    private JButton registerButton = new JButton();
    private JButton closeButton = new JButton();

    public LoginWindow() {
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setUndecorated(true); //removes title bar
        makeDraggable();
        editElements();
        addElements();
        addListeners();
        setVisible(true);
    }

    private void makeDraggable() {
        FrameDragListener frameDragListener = new FrameDragListener(this);
        addMouseListener(frameDragListener);
        addMouseMotionListener(frameDragListener);
    }

    private void editElements(){
        editPanel();
        labelIcon.setIcon(icon);
        labelIcon.setBounds((WIDTH/2)-50-BORDER_THICKNESS,30,100,76);

        userTextField.setBounds((WIDTH/2)-50-BORDER_THICKNESS,130,100,25);
        editTextField(userTextField);

        passwordTextField.setBounds((WIDTH/2)-50-BORDER_THICKNESS,156,100,25);
        editTextField(passwordTextField);

        loginButton.setBounds((WIDTH/2)-50-BORDER_THICKNESS,185,100,25);
        editButton(loginButton, null,"/loginButton.png");

        registerButton.setBounds((WIDTH/2)-50-BORDER_THICKNESS,211,100,25);
        editButton(registerButton, null,"/registerButton.png");

        closeButton.setBounds((WIDTH/2)-50-BORDER_THICKNESS,237,100,25);
        editButton(closeButton, null,"/closeButton.png");
    }

    private void editButton(JButton button, Border border, String imagePath){
        button.setBorder(border);
        button.setIcon(ImageHelper.openImageAsIcon(imagePath));
    }

    private void editPanel(){
        setBackground(UIColor.BACKGROUND_COLOR);
        panel.setBackground(UIColor.BACKGROUND_COLOR);
        panel.setLayout(null);
        panel.setBorder(new LineBorder(Color.BLACK, BORDER_THICKNESS));
    }

    private void editTextField(JTextField jTextField){
        jTextField.setBackground(UIColor.TEXT_FIELD_COLOR);
        jTextField.setBorder(new LineBorder(Color.BLACK));
        jTextField.setSelectionColor(Color.WHITE);
        jTextField.setSelectedTextColor(Color.BLACK);
        jTextField.setCaretColor(Color.WHITE); //cursor
        jTextField.setForeground(Color.WHITE); //font color
    }

    private void addElements(){
        add(panel);
        panel.add(userTextField);
        panel.add(passwordTextField);
        panel.add(loginButton);
        panel.add(closeButton);
        panel.add(labelIcon);
        panel.add(registerButton);
    }

    private void addListeners(){
        closeButton.addActionListener(e -> System.exit(0));

        loginButton.addActionListener(e -> {
            if(LoginValidator.validate()){
                System.out.println(userTextField.getText() + passwordTextField.getText());
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterDialog registerDialog = new RegisterDialog();
            }
        });

        addMouseListener(loginButton, "/loginButtonHover.png", "/loginButton.png");
        addMouseListener(registerButton, "/registerButtonHover.png", "/registerButton.png");
        addMouseListener(closeButton, "/closeButtonHover.png", "/closeButton.png");
    }

    private void addMouseListener(JButton button, String hoverImage, String image){
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                editButton(button, null, hoverImage);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                editButton(button, null, image);
            }
        });
    }
}
