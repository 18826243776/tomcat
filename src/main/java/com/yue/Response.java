package com.yue;

import java.io.*;

public class Response {
    private OutputStream outputStream;
    private Request request;
    private static final int BUFFER_SIZE=2048;

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public Response(OutputStream os, Request request) {
        this.outputStream = os;
        this.request=request;
    }

    public void setStaticResource() throws IOException {
        String uri = request.getUri();
        File file = new File(HttpServer.WEB_ROOT, uri);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);

            byte[] data = new byte[BUFFER_SIZE];
            int read = 0;
            StringBuffer sb = new StringBuffer(10000);
            sb.append("http1/1.1 200 ok\n" +
                    "\n\n");
            while ((read = fileInputStream.read(data)) != -1) {
                sb.append(new String(data));
            }
            outputStream.write(sb.toString().getBytes());
        } catch (FileNotFoundException e){
            String errMessage="HTTP/1.1 404 File Not Found \r\n"+
                    "Content-Type:text/html\r\n"+
                    "Content-Length:23\r\n"+
                    "\r\n"+
                    "<h1>File Not Found</h1>";
            outputStream.write(errMessage.getBytes());
        }finally {
            if (fileInputStream!=null){
                fileInputStream.close();
            }
        }
    }

}
