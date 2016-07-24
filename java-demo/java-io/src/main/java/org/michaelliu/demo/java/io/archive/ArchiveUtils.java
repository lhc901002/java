package org.michaelliu.demo.java.io.archive;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.jar.JarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by michael on 2016/7/24.
 */
public class ArchiveUtils {

    private static Log log = LogFactory.getLog(ArchiveUtils.class);

    public static void addToArchive(File srcDir, File destFile) {
        OutputStream output = null;
        try {
            String extension = getExtension(getName(destFile));
            output = new FileOutputStream(destFile);
            createArchive(srcDir, extension, output);
        } catch (IOException e) {
            log.error(e);
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                log.error(e);
            }
        }
    }

    private static void createArchive(File srcDir,
                                      String extension,
                                      OutputStream output) throws IOException {
        ArchiveOutputStream archive = null;
        try {
            archive = new ArchiveStreamFactory().createArchiveOutputStream(extension, output);
            Collection<File> files = FileUtils.listFiles(srcDir, null, true);
            Iterator<File> iterator = files.iterator();
            while (iterator.hasNext()) {
                File file = iterator.next();
                ArchiveEntry entry;
                String fileName = getName(file);
                if (extension.equals(ArchiveStreamFactory.ZIP)) {
                    entry = new ZipArchiveEntry(fileName);
                } else if (extension.equals(ArchiveStreamFactory.TAR)) {
                    entry = new TarArchiveEntry(fileName);
                    ((TarArchiveEntry) entry).setSize(file.length());
                } else if (extension.equals(ArchiveStreamFactory.JAR)) {
                    entry = new JarArchiveEntry(fileName);
                    ((JarArchiveEntry) entry).setSize(file.length());
                } else {
                    throw new IllegalArgumentException("File extension is not an archive type!");
                }
                archive.putArchiveEntry(entry);
                InputStream input = new FileInputStream(file);
                IOUtils.copy(input, archive);
                input.close();
                archive.closeArchiveEntry();
            }
            archive.finish();
        } catch (ArchiveException e) {
            log.error(e);
        } finally {
            try {
                if (archive != null) {
                    archive.close();
                }
            } catch (IOException e) {
                log.error(e);
            }
        }
    }

    private static String getExtension(String filePath) {
        int index = filePath.lastIndexOf(".");
        String extension = filePath.substring(index + 1);
        log.info("File extension: " + extension);
        return extension;
    }

    private static String getName(String filePath) {
        String fileName = "";
        int index = filePath.lastIndexOf("\\");
        if (index == -1) {
            fileName = filePath;
        } else {
            fileName = filePath.substring(index);
        }
        return fileName;
    }

    private static String getName(File file) throws IOException {
        String filePath = file.getCanonicalPath();
        log.info("File path: " + filePath);
        return getName(filePath);
    }

}
