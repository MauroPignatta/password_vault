package com.company.factory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFactory {

    private static BufferedImage createBufferedImage(String path){
        BufferedImage image = null;
        try{
            image = ImageIO.read(new File(path));
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return image;
    }

    public static ImageIcon createImageIcon(String path){
        return new ImageIcon(createBufferedImage(path));
    }
}
