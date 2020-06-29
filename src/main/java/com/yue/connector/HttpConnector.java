package com.yue.connector;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 千里明月 on 2018/8/26.
 */
public class HttpConnector implements Runnable {
    boolean stopped;

    public String getScheme() {
        return scheme;
    }

    private String scheme = "http";

    public void start() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        int port = 8080;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Socket socket = null;
        while (!stopped) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
        HttpProcessor processor = new HttpProcessor(this);
        processor.process(socket);
    }
}
