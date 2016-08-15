package com.michaelliu.demo.java.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Michael on 8/15/16.
 *
 */
public class EchoServer2 {

    private ServerSocket serverSocket;

    public EchoServer2(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started!");
    }

    /**
     * This code might throw java.net.SocketException: Connection reset
     */
    public void service() {
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("Connnected to server, client ip: " + socket.getInetAddress() + ":" + socket.getPort());
                OutputStream output = socket.getOutputStream();
                InputStream input = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int read;
                while ((read = input.read(buffer, 0, buffer.length)) != -1) {
                    output.write(buffer, 0, read);
                    System.out.println("Server receives: " + new String(buffer, "UTF-8"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            new EchoServer2(8000).service();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
