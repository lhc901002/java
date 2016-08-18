package com.michaelliu.demo.java.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Michael on 8/18/16.
 */
public class EchoServer3 {

    private ServerSocket serverSocket;

    private ExecutorService executor;

    public EchoServer3(int port, int nThreads) throws IOException {
        serverSocket = new ServerSocket(port);
        executor = Executors.newFixedThreadPool(nThreads);
        System.out.println("Server started!");
    }

    /**
     * multithread service
     */
    public void service() {
        while (true) {
            Socket socket;
            try {
                socket = serverSocket.accept();
                executor.execute(new EchoServerHandler(socket));
                // Normal start!
//                Thread thread = new Thread(new EchoServerHandler(socket));
//                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class EchoServerHandler implements Runnable {

        private Socket socket;

        public EchoServerHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                System.out.println("Connnected to server, client ip: " + socket.getInetAddress() + ":" + socket.getPort());
                BufferedReader reader = getReader(socket);
                PrintWriter writer = getWriter(socket);
                String message;
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

        private PrintWriter getWriter(Socket socket) throws IOException {
            OutputStream output = socket.getOutputStream();
            return new PrintWriter(output, true);
        }

        private BufferedReader getReader(Socket socket) throws IOException {
            InputStream input = socket.getInputStream();
            return new BufferedReader(new InputStreamReader(input));
        }

    }

    public static void main(String[] args) {
        try {
            new EchoServer3(8000, 3).service();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
