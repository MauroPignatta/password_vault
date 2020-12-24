package com.Sabuin.util;

import net.sf.image4j.codec.ico.ICODecoder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

public class ImageUtils {

    public static Image openImageFromResources(String path){
        return openImage(ImageUtils.class.getResourceAsStream(path));
    }

    public static Image openImage(String path){
        try {
            return openImage(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Image openImage(InputStream stream) {
        try {
            Image image = ImageIO.read(stream);
            stream.close();
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Image openImageFromURL(URL url){
        if(url.toString().endsWith("ico"))
            return openICOFromURL(url);

        if(url.toString().endsWith("png"))
            return openPNGFromURL(url);

        if(url.toString().endsWith("jpg"))
            return openJPGFromURL(url);

        return null;
    }

    private static Image openJPGFromURL(URL url) {
        return openPNGFromURL(url);
    }

    private static Image openPNGFromURL(URL url) {
        try {
            return openImage(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Image openICOFromURL(URL url){
        BufferedImage image = null;
        try {
            List<BufferedImage> images = ICODecoder.read(url.openStream());
            if(images.size() > 0){
                image = images.get(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public static ImageIcon openImageFromResourcesAsIcon(String path){
        return new ImageIcon(openImageFromResources(path));
    }

}
