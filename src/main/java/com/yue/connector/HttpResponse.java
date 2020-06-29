package com.yue.connector;

import com.sun.deploy.net.MessageHeader;

import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by 千里明月 on 2018/8/26.
 */
public class HttpResponse implements com.sun.deploy.net.HttpResponse {
    private HttpRequest request;
    public HttpResponse(OutputStream output) {

    }

    @Override
    public URL getRequest() {
        return null;
    }

    @Override
    public int getStatusCode() {
        return 0;
    }

    @Override
    public int getContentLength() {
        return 0;
    }

    @Override
    public long getExpiration() {
        return 0;
    }

    @Override
    public long getLastModified() {
        return 0;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public String getResponseHeader(String s) {
        return null;
    }

    @Override
    public BufferedInputStream getInputStream() {
        return null;
    }

    @Override
    public void disconnect() {

    }

    @Override
    public String getContentEncoding() {
        return null;
    }

    @Override
    public MessageHeader getHeaders() {
        return null;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public void setHeader(String server, String s) {
        
    }
}
