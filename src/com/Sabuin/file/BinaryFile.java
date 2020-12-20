package com.Sabuin.file;

import com.Sabuin.config.Config;
import com.sun.istack.internal.Nullable;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BinaryFile {

    private File file;

    public BinaryFile(String filename) {
        createOrOpenFile(null, filename);
    }

    public BinaryFile(@Nullable String directory, String filename) {
        createOrOpenFile(directory, filename);
    }

    private void createOrOpenFile(@Nullable String directory, String filename) {
        String finalDirectory = Config.getConfig().getHomePath() + "\\";
        if(directory != null){
            finalDirectory += directory + "\\";
        }

        File directoryFile = new File(finalDirectory);
        directoryFile.mkdirs();

        finalDirectory += filename;
        this.file = new File(finalDirectory);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean write(String text){
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(text.getBytes(StandardCharsets.UTF_8));
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String toString(){
        FileInputStream fileInputStream = null;
        StringBuilder builder = null;
        try {
            fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[4096];
            builder = new StringBuilder();

            while(fileInputStream.read(bytes) > 0){
                builder.append(new String(bytes));
            }
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder != null ? builder.toString() : "";
    }


}
