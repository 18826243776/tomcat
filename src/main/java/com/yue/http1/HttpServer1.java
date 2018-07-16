package com.yue.http1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 千里明月 on 2018/7/16.
 */
public class HttpServer1 {

    public static String WEB_ROOT = new HttpServer1().getClass().getResource("/").getPath();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // 创建一个服务端，监听端口8888
        while (true) {
            Socket socket = serverSocket.accept(); // 等待客户端连接过来
            System.out.println("来客IP： " + socket.getInetAddress()); // 获取来客的IP地址

            InputStream is = socket.getInputStream();// 客户端的输入流
            Request1 request = new Request1(is);

            // 增加一个自动回复
            OutputStream os = socket.getOutputStream();// 添加一个客户端输出
            Response1 response = new Response1(os, request);
            String uri = request.getUri();
            if (uri != null && uri.startsWith("/servlet/")) {
                ServeletProcessor serveletProcessor = new ServeletProcessor();
                try {
                    serveletProcessor.process(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                StaticResourcesProcessor staticResourcesProcessor = new StaticResourcesProcessor();
                staticResourcesProcessor.process(request, response);
            }

            is.close();
            os.close();
            socket.close();
        }
    }
}
