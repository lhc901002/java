package org.michaelliu.demo.java.io.archive;

import java.io.File;

/**
 * Created by michael on 2016/7/24.
 */
public class ArchiveExample {

    public static void main(String[] args) {
        ArchiveUtils.addToArchive(new File("E:\\Textbooks2"), new File("E:\\Textbooks2.jar"));
    }

}
