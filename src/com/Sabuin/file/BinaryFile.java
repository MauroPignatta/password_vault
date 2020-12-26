package com.Sabuin.file;

import com.sun.istack.internal.Nullable;

import java.io.*;

import static com.Sabuin.util.FileUtils.createOrOpenFile;

public class BinaryFile {

    private File file;

    public BinaryFile(String filename) {
        file = createOrOpenFile(filename);
    }

    public BinaryFile(@Nullable String directory, String filename) {
        file = createOrOpenFile(directory, filename);
    }

    public void write(String text){
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
            dos.writeUTF(text);
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String read(){
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

        return builder != null && builder.length() > 1? builder.toString().trim().substring(1) : "";
    }

    public String getPath(){
        return file.getPath();
    }

}
