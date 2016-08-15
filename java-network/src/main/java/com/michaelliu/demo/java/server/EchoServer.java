package com.michaelliu.demo.java.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Michael on 8/15/16.
 */
public class EchoServer {

    private int port;

    private ServerSocket serverSocket;

    public EchoServer(int port) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(port);
        System.out.println("Server started!");
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream output = socket.getOutputStream();
        return new PrintWriter(output, true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream input = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(input));
    }

    public void service() {
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("Connnected to server, client ip: " + socket.getInetAddress() + ":" + socket.getPort());
                BufferedReader reader = getReader(socket);
                PrintWriter writer = getWriter(socket);
                String message = null;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Server receives: " + message);
                    writer.println("Echo " + message);
                    if (message.equals("exit")) {
                        break;
                    }
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
            new EchoServer(8000).service();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
