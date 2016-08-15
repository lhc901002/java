package com.michaelliu.demo.java.client;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by Michael on 8/15/16.
 */
public class TimeoutClient {

    private Socket socket;

    /**
     * set time out seconds in the constructor, show time cost on connection.
     * @param host
     * @param port
     * @throws IOException
     */
    public TimeoutClient(String host, int port) throws IOException {
        long begin = System.currentTimeMillis();
        socket = new Socket();
        SocketAddress endpoint = new InetSocketAddress(host, port);
        socket.connect(endpoint, 5000);
        long end = System.currentTimeMillis();
        System.out.println("Connection costs: " + (end - begin) + " ms");
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
            PrintWriter writer = getWriter(socket);
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
            String message = null;
            while ((message = reader.readLine()) != null) {
                System.out.println("Client sends: " + message);
                writer.println(message);
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
            new TimeoutClient("127.0.0.1", 8000).connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
