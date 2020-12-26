package com.Sabuin.util;

import com.Sabuin.config.Config;
import com.sun.istack.internal.Nullable;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static File createOrOpenFile(String filename) {
        return createOrOpenFile(null, filename);
    }

    public static File createOrOpenFile(@Nullable String directory, @Nullable String filename) {
        String finalDirectory = Config.getConfig().getHomePath() + "\\";
        if(directory != null){
            finalDirectory += directory + "\\";
        }

        File directoryFile = new File(finalDirectory);
        directoryFile.mkdirs();

        if(filename == null){
            return directoryFile;
        }

        finalDirectory += filename;
        File file = new File(finalDirectory);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

}
