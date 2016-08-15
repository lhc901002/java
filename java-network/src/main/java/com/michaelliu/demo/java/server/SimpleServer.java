package com.michaelliu.demo.java.server;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by Michael on 8/15/16.
 */
public class SimpleServer {

    private ServerSocket serverSocket;

    public SimpleServer(int port, int size) throws IOException {
        serverSocket = new ServerSocket(port, size);
        System.out.println("Server started!");
    }

    public void service() throws IOException {
        while (true) {
            serverSocket.accept();
        }
    }

    public static void main(String[] args) {
        try {
            new SimpleServer(8000, 2).service();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
