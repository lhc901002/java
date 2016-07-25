package org.michaelliu.demo.java.io;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Michael on 7/25/16.
 */
public class SimpleIOStreamExample {

    private static Log log = LogFactory.getLog(SimpleIOStreamExample.class);

    public static void main(String[] args) {
        InputStream input = null;
        OutputStream output = null;
        try {
            long startCurrentTimeInMillionSeconds = System.currentTimeMillis();
            input = new FileInputStream(new File("input.txt"));
            output = new FileOutputStream(new File("output.txt"));
            int size = Integer.MAX_VALUE - 600000000;
            log.info("Buffer size: " + size);
            byte [] buffer = new byte[size];
            int read = 0;
            while ((read = input.read(buffer)) != -1) {
                output.write(buffer, 0, read);
            }
            long endCurrentTimeInMillionSeconds = System.currentTimeMillis();
            log.info("IO cost: " + (endCurrentTimeInMillionSeconds - startCurrentTimeInMillionSeconds) + "ms");
        } catch (IOException e) {
            log.error(e);
        }  finally {
            try {
                if (output != null) {
                    output.close();
                }
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                log.error(e);
            }
        }
    }

}
