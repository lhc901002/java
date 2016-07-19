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
public class BlockingMessageReceiver {

    public BlockingMessageReceiver(int port) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("accept connection from client");
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    if (line.equals("quit") || line.equals("exit")) {
                        out.write("Bye bye!\n".getBytes());
                        break;
                    } else {
                        String rsp = "Server received: " + line + "\n";
                        out.write(rsp.getBytes());
                    }
                }
                if (reader != null) reader.close();
                if (out != null) out.close();
                if (in != null) in.close();
                if (socket != null) socket.close();
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
            new BlockingMessageReceiver(8001);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
