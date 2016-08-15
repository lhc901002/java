package com.michaelliu.demo.java.server;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by Michael on 8/15/16.
 */
public class TimeoutServer {

    private ServerSocket serverSocket;

    public TimeoutServer(int port, int timeout) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(timeout);
        System.out.println("Server started!");
    }

    public void service() throws IOException {
        while (true) {
            serverSocket.accept();
        }
    }

    public static void main(String[] args) {
        try {
            // "java.net.SocketTimeoutException: Accept timed out" after running 5 seconds
            new TimeoutServer(8000, 5000).service();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
