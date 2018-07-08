import java.io.*;
import java.net.Socket;

public class MySocket {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",8080);

        //构建IO
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();

        byte[] data = "开门,我要进去!".getBytes();
        //向服务器端发送一条消息
        os.write(data);
        os.flush();

        //读取服务器返回的消息
//        InputStreamReader inputStreamReader = new InputStreamReader(is);
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        System.out.println("服务器："+bufferedReader.readLine());
        byte[] bytes = new byte[1024];
        is.read(bytes);
        System.out.println(new String(bytes));

        os.close();
        is.close();
    }
}
