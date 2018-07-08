package com.yue;


import java.io.IOException;
import java.io.InputStream;

/**
 * 解析请求
 */
public class Request {


    private InputStream inputStream;
    private String uri;

    public Request(InputStream inputStream) {
        this.inputStream = inputStream;
    }


    public String parseURI() {
        StringBuffer sb = new StringBuffer(8080);
        byte[] buffer = new byte[2048];
        try {
            inputStream.read(buffer);
            sb.append(new String(buffer, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String requestContent = sb.toString();
        int index1 = requestContent.indexOf(" ");
        int index2 = requestContent.indexOf(" ", index1 + 1);
        this.uri = requestContent.substring(index1 + 1, index2);
        System.out.println(uri);
        return this.uri;
    }


    public String getUri() {
        return parseURI();
    }

}
