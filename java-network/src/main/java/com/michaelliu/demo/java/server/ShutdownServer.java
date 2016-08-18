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
import java.util.concurrent.TimeUnit;

/**
 * Created by Michael on 8/18/16.
 */
public class ShutdownServer {

    private ServerSocket serverSocket;

    private ExecutorService executor;

    public ShutdownServer(int port, int shutdownPort, int nThreads) throws IOException {
        serverSocket = new ServerSocket(port);
        executor = Executors.newFixedThreadPool(nThreads);
        new Thread(new AdminServer(shutdownPort)).start();
        System.out.println("Server started!");
    }

    private class AdminServer implements Runnable {

        private ServerSocket shutdownSocket;

        public AdminServer(int port) throws IOException {
            shutdownSocket = new ServerSocket(port);
            System.out.println("Admin Server started!");
        }

        @Override
        public void run() {
            while (true) {
                Socket socket = null;
                try {
                    socket = shutdownSocket.accept();
                    System.out.println("Connnected to server, client ip: " + socket.getInetAddress() + ":" + socket.getPort());
                    BufferedReader reader = getReader(socket);
                    PrintWriter writer = getWriter(socket);
                    String message;
                    while ((message = reader.readLine()) != null) {
                        System.out.println("Server receives: " + message);
                        if (message.equals("shutdown")) {
                            writer.println("Server will showndown!");
                            executor.shutdown();
                            while (!executor.isTerminated()) {
                                executor.awaitTermination(10, TimeUnit.SECONDS);
                            }
                            if (serverSocket != null) {
                                serverSocket.close();
                                writer.println("Server has terminated!");
                            }
                            break;
                        }
                    }
                } catch (Exception e) {
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
    }

    /**
     * multithread service
     */
    public void service() {
        while (!serverSocket.isClosed()) {
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


    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream output = socket.getOutputStream();
        return new PrintWriter(output, true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream input = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(input));
    }

    public static void main(String[] args) {
        try {
            new ShutdownServer(8000, 8001, 3).service();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
