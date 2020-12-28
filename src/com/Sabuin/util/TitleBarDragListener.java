package com.Sabuin.util;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * jPanel acts as the titleBar in order to move the jFrame
 */
public class TitleBarDragListener extends JFrame{

    int pX, pY;
    JPanel jPanel;
    JFrame jFrame;

    public TitleBarDragListener(JPanel jPanel, JFrame jFrame) {
        this.jPanel = jPanel;
        this.jFrame = jFrame;

        jPanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                pX = me.getX();
                pY = me.getY();
            }
            public void mouseDragged(MouseEvent me) {

                jFrame.setLocation(jFrame.getLocation().x + me.getX() - pX,
                        jFrame.getLocation().y + me.getY() - pY);
            }
        });

        jPanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent me) {
                jFrame.setLocation(jFrame.getLocation().x + me.getX() - pX,
                        jFrame.getLocation().y + me.getY() - pY);
            }
        });
    }

}
