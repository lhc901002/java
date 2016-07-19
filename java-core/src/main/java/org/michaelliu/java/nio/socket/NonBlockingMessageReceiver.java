package org.michaelliu.java.nio.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Michael on 7/19/16.
 */
public class NonBlockingMessageReceiver {

    public NonBlockingMessageReceiver(int port) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.configureBlocking(false);
        ServerSocket serverSocket = ssChannel.socket();
        serverSocket.bind(new InetSocketAddress(InetAddress.getByName("localhost"), port));
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            try {
                selector.select();
            } catch (IOException e) {
                System.err.println(e);
            }
            Set readyKeys = selector.selectedKeys();
            Iterator iterator = readyKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = (SelectionKey) iterator.next();
                iterator.remove();
                try {
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = (SocketChannel) ssChannel.accept();
                        System.out.println("Accepted connection from " + client);
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, ByteBuffer.allocate(100));
                    }
                    if (key.isReadable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        output.flip();
                        client.write(output);
                        output.compact();
                    }
                } catch (IOException e) {
                    System.err.println(e);
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException cex) {
                        System.err.println(cex);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            new NonBlockingMessageReceiver(8001);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
