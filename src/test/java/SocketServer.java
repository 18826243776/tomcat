
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // 创建一个服务端，监听端口8888
        while (true){

            Socket socket = serverSocket.accept(); // 等待客户端连接过来
            System.out.println("来客IP： " + socket.getInetAddress()); // 获取来客的IP地址


            // 增加一个自动回复
            OutputStream os = socket.getOutputStream();// 添加一个客户端输出
            File file = new File("C:\\Users\\47952\\Desktop\\index.html");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] data = new byte[2048];
            int read = 0;
            StringBuffer sb = new StringBuffer(10000);
            sb.append("http1/1.1 200 ok\n" +
                "\n\n");
            while ((read=fileInputStream.read(data))!=-1){
                sb.append(new String(data));
            }
            os.write(sb.toString().getBytes());
            os.flush();

//        byte[] answer = ("http1/1.1 200 ok\n" +
//                "                +\n\n"+"<html>\n" +
//                "<h1>欢迎来到我的世界</h1>\n" +
//                "</html>").getBytes();
//        os.write(answer);

            InputStream is = socket.getInputStream();// 客户端的输入流
            byte[] bytes = new byte[2048];
            is.read(bytes);
            System.out.println(new String(bytes));

            is.close();
            os.close();
        }
    }
}
