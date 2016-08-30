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
public class EchoClient {

    private Socket socket;

    public EchoClient(String host, int port) throws IOException {
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

    /**
     * This socket sends messages using character stream
     */
    public void connect() throws IOException {
        try {
            PrintWriter writer = getWriter(socket);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
            String message;
            while ((message = bufferedReader.readLine()) != null) {
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
            new EchoClient("127.0.0.1", 8000).connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
