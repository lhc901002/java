package org.michaelliu.demo.java.io.archive;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by michael on 2016/7/24.
 */
public class UnzipArchiveExample {

    private static Log log = LogFactory.getLog(UnzipArchiveExample.class);

    public void unzip(String zipFilePath, String destDir) {
        ZipFile zipFile = null;
        OutputStream output = null;
        InputStream input = null;
        try {
            File dir = new File(destDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            zipFile = new ZipFile(zipFilePath);
            Enumeration<?> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                input = zipFile.getInputStream(entry);
                log.info("Unzip file name: " + entry.getName());
                output = new FileOutputStream(destDir + entry.getName());
                byte[] buffer = new byte[2048];
                int read;
                while ((read = input.read(buffer)) != -1) {
                    output.write(buffer, 0, read);
                }

            }
        } catch (IOException e) {
            log.error(e);
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
                if (zipFile != null) {
                    zipFile.close();
                }
            } catch (IOException e) {
                log.error(e);
            }
        }
    }

    public static void main(String[] args) {
        new UnzipArchiveExample().unzip("/home/documents/archive.zip", "/home/documents/archive");
    }

}
