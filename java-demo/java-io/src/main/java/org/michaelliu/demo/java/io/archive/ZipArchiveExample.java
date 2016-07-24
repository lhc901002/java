package org.michaelliu.demo.java.io.archive;

import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by michael on 2016/7/24.
 */
public class ZipArchiveExample {

    private static Log log = LogFactory.getLog(ZipArchiveExample.class);

    public void addToZip(List<String> srcPathList, String destPath) {
        OutputStream output = null;
        ArchiveOutputStream archive = null;
        try {
            output = new FileOutputStream(destPath);
            archive = new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.ZIP, output);
            for (String filePath : srcPathList) {
                addZipEntry(archive, filePath);
            }
            archive.finish();
        } catch (Exception e) {
            log.error(e);
        } finally {
            try {
                if (archive != null) {
                    archive.close();
                }
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                log.error(e);
            }
        }
    }

    public void addToZip(List<File> srcFileList, File destFile) {
        OutputStream output = null;
        ArchiveOutputStream archive = null;
        try {
            output = new FileOutputStream(destFile);
            archive = new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.ZIP, output);
            for (File file : srcFileList) {
                addZipEntry(archive, file);
            }
            archive.finish();
        } catch (Exception e) {
            log.error(e);
        } finally {
            try {
                if (archive != null) {
                    archive.close();
                }
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                log.error(e);
            }
        }
    }

    public void addToZip(File srcDir, File destFile) {
        OutputStream output = null;
        ArchiveOutputStream archive = null;
        try {
            output = new FileOutputStream(destFile);
            archive = new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.ZIP, output);
            Collection<File> files = FileUtils.listFiles(srcDir, null, true);
            Iterator<File> iterator = files.iterator();
            while (iterator.hasNext()) {
                File file = iterator.next();
                addZipEntry(archive, file);
            }
            archive.finish();
        } catch (Exception e) {
            log.error(e);
        } finally {
            try {
                if (archive != null) {
                    archive.close();
                }
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                log.error(e);
            }
        }
    }

    private void addZipEntry(ArchiveOutputStream archive, String filePath) throws IOException {
        ZipArchiveEntry zipEntry = new ZipArchiveEntry(getName(filePath));
        archive.putArchiveEntry(zipEntry);
        InputStream input = new FileInputStream(filePath);
        IOUtils.copy(input, archive);
        input.close();
        archive.closeArchiveEntry();
    }

    private void addZipEntry(ArchiveOutputStream archive, File file) throws IOException {
        ZipArchiveEntry zipEntry = new ZipArchiveEntry(getName(file));
        archive.putArchiveEntry(zipEntry);
        InputStream input = new FileInputStream(file);
        IOUtils.copy(input, archive);
        input.close();
        archive.closeArchiveEntry();
    }

    private String getName(String filePath) {
        String fileName = "";
        int index = filePath.lastIndexOf("\\");
        if (index == -1) {
            fileName = filePath;
        } else {
            fileName = filePath.substring(index);
        }
        return fileName;
    }

    private String getName(File file) throws IOException {
        String filePath = file.getCanonicalPath();
        log.info("File path: " + filePath);
        return getName(filePath);
    }

    public static void main(String[] args) throws IOException {
        Collection<File> files = FileUtils.listFiles(new File("/home/documents"), null, true);
        List<File> fileList = new ArrayList<File>();
        fileList.addAll(files);
        new ZipArchiveExample().addToZip(fileList, new File("/home/documents"));
    }

}
