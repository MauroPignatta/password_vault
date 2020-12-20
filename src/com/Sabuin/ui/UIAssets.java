package com.Sabuin.ui;

import com.Sabuin.enums.Theme;
import com.Sabuin.helper.ImageHelper;

import javax.swing.*;
import java.awt.*;

public class UIAssets {

    public static Color PANEL_BACKGROUND;
    public static Color PANEL_BACKGROUND_NO_TRANSPARENCY;
    public static Color PANEL_BACKGROUND_BORDER_B;
    public static Color PANEL_BACKGROUND_BORDER;
    public static Color TEXT_FIELD_BACKGROUND;
    public static Color TEXT_FIELD_BORDER;
    public static Color TEXT_FIELD_SELECTION;
    public static Color TEXT_FIELD_SELECTED_TEXT;
    public static Color TEXT_FIELD_CARET; //cursor
    public static Color TEXT_FIELD_FOREGROUND; //font color

    public static ImageIcon LOGO_IMG;
    public static ImageIcon LOGIN_BUTTON_IMG;
    public static ImageIcon LOGIN_HOVER_BUTTON_IMG;
    public static ImageIcon REGISTER_BUTTON_IMG;
    public static ImageIcon REGISTER_HOVER_BUTTON_IMG;
    public static ImageIcon CLOSE_BUTTON_IMG;
    public static ImageIcon CLOSE_HOVER_BUTTON_IMG;
    public static ImageIcon BACK_BUTTON_IMG;
    public static ImageIcon BACK_HOVER_BUTTON_IMG;

    public static void init(Theme theme){
        switch (theme){
            case DARK_RED:
                PANEL_BACKGROUND = new Color(0,0,0,0.7f);
                PANEL_BACKGROUND_NO_TRANSPARENCY = new Color(0,0,0);
                PANEL_BACKGROUND_BORDER_B = Color.BLACK;
                PANEL_BACKGROUND_BORDER = new Color(255,25,25, 100);
                TEXT_FIELD_BACKGROUND = new Color(36,36,36);
                TEXT_FIELD_BORDER = Color.BLACK;
                TEXT_FIELD_SELECTION = Color.WHITE; //barra que selecciona
                TEXT_FIELD_SELECTED_TEXT = Color.BLACK; //color que obtiene el texto al ser seleccionado
                TEXT_FIELD_CARET = Color.WHITE; //cursor
                TEXT_FIELD_FOREGROUND = Color.WHITE; //color de la fuente

                LOGO_IMG = ImageHelper.openImageAsIcon("/logo.png");
                LOGIN_BUTTON_IMG = ImageHelper.openImageAsIcon("/loginButton.png");
                LOGIN_HOVER_BUTTON_IMG = ImageHelper.openImageAsIcon("/loginButtonHover.png");
                REGISTER_BUTTON_IMG = ImageHelper.openImageAsIcon("/registerButton.png");
                REGISTER_HOVER_BUTTON_IMG = ImageHelper.openImageAsIcon("/registerButtonHover.png");
                CLOSE_BUTTON_IMG = ImageHelper.openImageAsIcon("/closeButton.png");
                CLOSE_HOVER_BUTTON_IMG = ImageHelper.openImageAsIcon("/closeButtonHover.png");
                BACK_BUTTON_IMG = ImageHelper.openImageAsIcon("/backButton.png");
                BACK_HOVER_BUTTON_IMG = ImageHelper.openImageAsIcon("/backButtonHover.png");
                break;
            case LIGHT_RED:
                PANEL_BACKGROUND = new Color(255,255,255,100);
                PANEL_BACKGROUND_NO_TRANSPARENCY = new Color(255,255,255);
                PANEL_BACKGROUND_BORDER_B = Color.WHITE;
                PANEL_BACKGROUND_BORDER = new Color(255,25,25, 100);
                TEXT_FIELD_BACKGROUND = new Color(244,244,244);
                TEXT_FIELD_BORDER = Color.WHITE;
                TEXT_FIELD_SELECTION = Color.BLACK;
                TEXT_FIELD_SELECTED_TEXT = Color.WHITE;
                TEXT_FIELD_CARET = Color.BLACK;
                TEXT_FIELD_FOREGROUND = Color.BLACK;

                LOGO_IMG = ImageHelper.openImageAsIcon("/logo.png");
                LOGIN_BUTTON_IMG = ImageHelper.openImageAsIcon("/loginButton.png");
                LOGIN_HOVER_BUTTON_IMG = ImageHelper.openImageAsIcon("/loginButtonHover.png");
                REGISTER_BUTTON_IMG = ImageHelper.openImageAsIcon("/registerButton.png");
                REGISTER_HOVER_BUTTON_IMG = ImageHelper.openImageAsIcon("/registerButtonHover.png");
                CLOSE_BUTTON_IMG = ImageHelper.openImageAsIcon("/closeButton.png");
                CLOSE_HOVER_BUTTON_IMG = ImageHelper.openImageAsIcon("/closeButtonHover.png");
                BACK_BUTTON_IMG = ImageHelper.openImageAsIcon("/backButton.png");
                BACK_HOVER_BUTTON_IMG = ImageHelper.openImageAsIcon("/backButtonHover.png");
        }
    }
}