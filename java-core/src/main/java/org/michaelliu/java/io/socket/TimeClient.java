package org.michaelliu.java.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by Michael on 7/19/16.
 */
public class TimeClient {

    public TimeClient(String host, int port) throws IOException {
        try {
            SocketAddress address = new InetSocketAddress(host, port);
            Socket socket = new Socket();
            socket.connect(address);
            Writer out = new OutputStreamWriter(socket.getOutputStream());
            out.write("query for current time");
            out.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
//            in.close();
//            out.close();
            socket.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void main(String args[]) {
        try {
            new TimeClient("127.0.0.1", 8001);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
