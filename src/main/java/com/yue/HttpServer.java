package com.yue;

//1.构建socketserver等待连接
//2.构建request处理客户端的输入流
//2.1 request解析客户的访问资源
//3.构建response处理服务端的响应

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    public static String WEB_ROOT = "D:/ideaHome/tomcat/src/main/resources/static/";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // 创建一个服务端，监听端口8888
        while (true){
            Socket socket = serverSocket.accept(); // 等待客户端连接过来
            System.out.println("来客IP： " + socket.getInetAddress()); // 获取来客的IP地址

            InputStream is = socket.getInputStream();// 客户端的输入流
            Request request = new Request(is);

            // 增加一个自动回复
            OutputStream os = socket.getOutputStream();// 添加一个客户端输出
            Response response = new Response(os,request);

            is.close();
            os.close();
            socket.close();
        }
    }
}
