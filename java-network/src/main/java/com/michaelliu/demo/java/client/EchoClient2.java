package com.michaelliu.demo.java.client;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Michael on 8/15/16.
 */
public class EchoClient2 {

    private String host;

    private int port;

    private Socket socket;

    public EchoClient2(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream output = socket.getOutputStream();
        return new PrintWriter(output, true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream input = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(input));
    }

    public void connect() throws IOException {
        try {
            OutputStream output = socket.getOutputStream();
            FileInputStream fis = new FileInputStream("input.txt");
            byte[] buffer = new byte[1024];
            int read;
            while ((read = fis.read(buffer)) != -1) {
                String message = new String(buffer, "UTF-8");
                System.out.println("Client sends: " + message);
                output.write(buffer);
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

    public static void main(String[] args) {
        try {
            new EchoClient("127.0.0.1", 8000).connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
