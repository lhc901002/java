package com.michaelliu.demo.java.server;

import com.alibaba.fastjson.JSON;
import com.michaelliu.demo.java.vo.AccountVo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Michael on 8/30/16.
 */
public class JsonServer {

    private ServerSocket serverSocket;

    public JsonServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started!");
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream input = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(input));
    }

    /**
     * char stream
     */
    public void service() {
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("Connnected to server, client ip: " + socket.getInetAddress() + ":" + socket.getPort());
                BufferedReader reader = getReader(socket);
                String json = reader.readLine();
                System.out.println("Server receives: " + json);
                AccountVo accountVo = JSON.parseObject(json, AccountVo.class);
                System.out.println("Object: " + accountVo);
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

    public static void main(String[] args) {
        try {
            new JsonServer(8000).service();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
