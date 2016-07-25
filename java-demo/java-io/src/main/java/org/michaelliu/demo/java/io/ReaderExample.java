package org.michaelliu.demo.java.io;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * Created by Michael on 7/19/16.
 *
 * Reader和Writer以char流形式执行IO操作，性能较byte流差，一般在程序里需要查询具体IO
 * 内容的时候使用。在网络传输时，只接受byte流，故不可使用Reader传输文件。
 */
public class ReaderExample {

    private static Log log = LogFactory.getLog(ReaderExample.class);

    public void copyFileByBufferedReader(String srcFile, String destFile) {
        Reader br = null;
        Writer bw = null;
        try {
            // or use br = new BufferedReader(new FileReader(srcFile));
            br = new BufferedReader(new InputStreamReader(new FileInputStream(srcFile), "UTF-8"));
            // or use bw = new BufferedWriter(new FileWriter(destFile));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destFile), "UTF-8"));
            char [] cbuf = new char[2048];
            int read = -1;
            while ((read = br.read(cbuf)) != -1) {
                bw.write(cbuf, 0, read);
                log.info("Char Buf: " + new String(cbuf));
                log.info("Read: " + read + " characters");
            }
        } catch (IOException e) {
            log.error(e);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                log.error(e);
            }
        }
    }

    public static void main(String[] args) {
        new ReaderExample().copyFileByBufferedReader("input.txt", "output.txt");
    }

}
