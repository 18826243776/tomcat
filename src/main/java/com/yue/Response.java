package com.yue;

import java.io.*;

public class Response {
    private OutputStream outputStream;

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }


    public Response(OutputStream os, Request request) {
        sendToClient(os, request.getUri());
    }

    public void sendToClient(OutputStream os, String uri) {
        File file = new File(HttpServer.WEB_ROOT, uri);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);

            byte[] data = new byte[2048];
            int read = 0;
            StringBuffer sb = new StringBuffer(10000);
            sb.append("http/1.1 200 ok\n" +
                    "\n\n");
            while ((read = fileInputStream.read(data)) != -1) {
                sb.append(new String(data));
            }
            os.write(sb.toString().getBytes());
//            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
