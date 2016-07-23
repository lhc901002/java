package org.michaelliu.demo.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Michael on 7/19/16.
 *
 * InputStream使用byte流形式做IO操作，IO效率高，但用户无法在程序里获取IO具体内容（
 * 因为全是以byte类型展示），只能从源文件和目标文件里查看内容。
 */
public class InputStreamExample {

    public void readFileByBufferedInputStream(String fileName, byte[] buffer) {
       InputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(fileName));
            int read = -1;
            do {
                read = bis.read(buffer, 0, buffer.length);
            } while (read != -1);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }

    public void writeFileByBufferedOutputStream(String fileName, byte[] buffer) {
        OutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(fileName));
            bos.write(buffer, 0, buffer.length);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }

    public void copyFileByBufferedStream(String srcFile, String destFile) {
        InputStream bis = null;
        OutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(srcFile));
            bos = new BufferedOutputStream(new FileOutputStream(destFile));
            if (bis.available() > 0) {
                byte[] buffer = new byte[4096];
                int read = -1;
                while ((read = bis.read(buffer)) != -1) {
                    System.out.println("Read: " + read + " bytes");
                    bos.write(buffer, 0, read);
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new InputStreamExample().copyFileByBufferedStream("input.txt", "output.txt");
    }

}
