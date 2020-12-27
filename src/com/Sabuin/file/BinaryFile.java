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
        String s = "";
        try {
            FileInputStream fis = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(fis);

            if (dis.available() > 0) {
                s = dis.readUTF();
            }

            dis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public String getPath(){
        return file.getPath();
    }

}
