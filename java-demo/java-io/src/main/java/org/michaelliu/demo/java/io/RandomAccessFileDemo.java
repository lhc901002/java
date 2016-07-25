package org.michaelliu.demo.java.io;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Michael on 2016/7/19.
 */
public class RandomAccessFileDemo {

    private static Log log = LogFactory.getLog(RandomAccessFileDemo.class);

    public void writeRandomAccessFile(String filePath) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(filePath, "rw");
            for (int i = 0; i < 10; i++) {
                // 写入Int型数据
                raf.writeInt(i);
            }
            raf.close();
            raf = new RandomAccessFile(filePath, "rw");
            // 将文件指针移到第5个int数据后面
            raf.seek(5 * Integer.SIZE / 8);
            // 覆盖第6个int数据
            raf.writeInt(666);
            raf.close();
            raf = new RandomAccessFile(filePath, "r");
            for (int i = 0; i < 10; i++) {
                log.info("Value " + i + ": " + raf.readInt());
            }
            raf.close();
        } catch (IOException e) {
            log.error(e);
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (IOException e) {
                log.error(e);
            }
        }
    }

    public void readFromFileChannel(String filePath) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(filePath, "rw");
            FileChannel inChannel = raf.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(32);
            int bytesRead;
            while ((bytesRead = inChannel.read(buf)) != -1) {
//                System.out.println("Read " + bytesRead + "Bs");
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }
                buf.clear();
            }
        } catch (IOException e) {
            log.error(e);
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (IOException e) {
                log.error(e);
            }
        }
    }

    public void writeIntoFileChannel(String filePath) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(filePath, "rw");
            FileChannel inChannel = raf.getChannel();
            // 将字符串写入文件
            inChannel.write(ByteBuffer.wrap("hello michael".getBytes()));
            inChannel.close();
        } catch (IOException e) {
            log.error(e);
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (IOException e) {
                log.error(e);
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        new RandomAccessFileDemo().writeRandomAccessFile("test.txt");
//        new RandomAccessFileDemo().readFromFileChannel("test.txt");
        new RandomAccessFileDemo().writeIntoFileChannel("test.txt");
    }

}