package com.michaelliu.demo.java.client;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Michael on 8/15/16.
 */
public class SimpleClient {

    public static void main(String[] args) throws IOException {
        Socket socket1 = new Socket("127.0.0.1", 8000);
        System.out.println("socket1 connected");
        Socket socket2 = new Socket("127.0.0.1", 8000);
        System.out.println("socket2 connected");
        Socket socket3 = new Socket("127.0.0.1", 8000);
        System.out.println("socket3 connected");
    }

}
