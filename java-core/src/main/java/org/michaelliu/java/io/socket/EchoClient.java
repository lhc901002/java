package org.michaelliu.java.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Michael on 7/19/16.
 */
public class EchoClient {

    public EchoClient(String host, int port) {
        try {
            Socket socket = new Socket(host, port);
            for(int i = 1; i <= 15; i++) {
                sendData(socket, "data" + i);
            }
            socket.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void sendData(Socket socket, String data) {
        try {
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            os.println(data);
            os.flush();
            System.out.println("Client:" + data);
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            System.out.println("Server:" + is.readLine());
        } catch (IOException e) {
            System.err.println(e);
        }

    }

    public static void main(String args[]) {
        new EchoClient("127.0.0.1", 8001);
    }

}
