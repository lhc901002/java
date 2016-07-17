package org.michaelliu.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOApp {

    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            long startCurrentTimeInMillionSeconds = System.currentTimeMillis();
            fis = new FileInputStream(new File("input.txt"));
            fos = new FileOutputStream(new File("output.txt"));
            int size = Integer.MAX_VALUE - 600000000;
            System.out.println(size);
            byte [] buffer = new byte[size];
            int read = 0;
            while ((read = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, read);
            }
            fos.close();
            fis.close();
            long endCurrentTimeInMillionSeconds = System.currentTimeMillis();
            System.out.println(endCurrentTimeInMillionSeconds - startCurrentTimeInMillionSeconds);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
