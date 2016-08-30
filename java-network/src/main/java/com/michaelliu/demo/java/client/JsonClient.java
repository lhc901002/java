package com.michaelliu.demo.java.client;

import com.alibaba.fastjson.JSON;
import com.michaelliu.demo.java.vo.AccountVo;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Michael on 8/30/16.
 */
public class JsonClient {

    private Socket socket;

    public JsonClient(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream output = socket.getOutputStream();
        return new PrintWriter(output, true);
    }

    private AccountVo createAccount() {
        AccountVo accountVo = new AccountVo();
        accountVo.setId(111l);
        accountVo.setBalance(100);
        accountVo.setName("Michael Liu");
        accountVo.setCreateTime("2016-01-01 00:00:00");
        accountVo.setUpdateTime("2016-01-01 00:00:00");
        return accountVo;
    }

    public void connect() throws IOException {
        try {
            PrintWriter writer = getWriter(socket);
            AccountVo accountVo = createAccount();
            String json = JSON.toJSONString(accountVo);
            System.out.println("Client sends json string: " + json);
            writer.println(json);
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
            new JsonClient("127.0.0.1", 8000).connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
