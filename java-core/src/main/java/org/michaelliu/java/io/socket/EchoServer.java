package org.michaelliu.java.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Michael on 7/19/16.
 */
public class EchoServer {

    public EchoServer(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("starting echo server on port: " + port);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("accept connection from client");
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            OutputStream os = socket.getOutputStream();
            byte[] buffer = new byte[4 * 1024];
            int length;
            while ((length = is.read(buffer)) != -1) {
                os.write(buffer, 0, length);
            }
            System.out.println("closing connection with client");
            os.close();
            is.close();
            socket.close();
        }
    }

    public static void main(String[] args) {
        try {
            new EchoServer(8001);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
