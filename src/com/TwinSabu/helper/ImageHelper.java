package com.TwinSabu.helper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class ImageHelper {

    public static Image openImage(String path){
        Image image = null;
        try {
            InputStream stream = ImageHelper.class.getResourceAsStream(path);
            if(stream != null){
                image =  ImageIO.read(stream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

}
