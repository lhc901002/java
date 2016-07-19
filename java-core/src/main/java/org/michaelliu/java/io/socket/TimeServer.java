package org.michaelliu.java.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Michael on 7/19/16.
 */
public class TimeServer {

    public TimeServer(int port) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("accept connection from client");

                Writer out = new OutputStreamWriter(socket.getOutputStream());
                Date now = new Date();
                out.write(now.toString());
//                out.flush();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = null;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
                out.close();
                in.close();
                socket.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    public static void main(String[] args) {
        try {
            new TimeServer(8001);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
