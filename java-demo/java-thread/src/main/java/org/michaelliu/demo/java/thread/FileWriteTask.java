package org.michaelliu.demo.java.thread;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;

/**
 * Created by michael on 2016/7/23
 *
 * This task write a sentence into a file, since the task can be called
 * by several threads, it must guarantee thread safety.
 */
public class FileWriteTask implements Callable<Integer> {

    private static Log log = LogFactory.getLog(FileWriteTask.class);

    private static final Object lock = new Object();

    public static Integer taskId = 0;

    private String filePath;

    private String sentence;

    public FileWriteTask(String filePath) {
        this(filePath, "Hello Thread\t" + System.currentTimeMillis() + "\n");
    }

    public FileWriteTask(String filePath, String sentence) {
        this.filePath = filePath;
        this.sentence = sentence;
    }

    @Override
    public Integer call() throws Exception {
        synchronized (lock) {
            OutputStream out = new FileOutputStream(filePath, true);
            out.write(sentence.getBytes());
            out.close();
            taskId++;
        }
        return taskId;
    }

}
