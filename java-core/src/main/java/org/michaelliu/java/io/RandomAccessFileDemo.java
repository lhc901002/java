package org.michaelliu.java.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Michael on 2016/7/19.
 */
public class RandomAccessFileDemo {

    public void writeRandomAccessFile(String filePath) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(filePath, "rw");
            for (int i = 0; i < 10; i++) {
                // д��Int������
                raf.writeInt(i);
            }
            raf.close();
            raf = new RandomAccessFile(filePath, "rw");
            // ���ļ�ָ���Ƶ���5��int���ݺ���
            raf.seek(5 * Integer.SIZE / 8);
            // ���ǵ�6��int����
            raf.writeInt(666);
            raf.close();
            raf = new RandomAccessFile(filePath, "r");
            for (int i = 0; i < 10; i++) {
                System.out.println("Value " + i + ": " + raf.readInt());
            }
            raf.close();
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (IOException e) {
                System.err.println(e);
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
            System.err.println(e);
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    public void writeIntoFileChannel(String filePath) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(filePath, "rw");
            FileChannel inChannel = raf.getChannel();
            // ���ַ���д���ļ�
            inChannel.write(ByteBuffer.wrap("hello michael".getBytes()));
            inChannel.close();
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        new RandomAccessFileDemo().writeRandomAccessFile("test.txt");
//        new RandomAccessFileDemo().readFromFileChannel("test.txt");
        new RandomAccessFileDemo().writeIntoFileChannel("test.txt");
    }

}
