package com.yue.connector;

import com.sun.deploy.net.HttpResponse;

import java.io.IOException;
import java.net.URL;

/**
 * Created by 千里明月 on 2018/8/26.
 */
public class HttpRequest implements com.sun.deploy.net.HttpRequest {
    private String requestURI;
    public HttpRequest(SocketInpuStream input) {

    }

    @Override
    public HttpResponse doGetRequestEX(URL url, long l) throws IOException {
        return null;
    }

    @Override
    public HttpResponse doGetRequestEX(URL url, String[] strings, String[] strings1, long l) throws IOException {
        return null;
    }

    @Override
    public HttpResponse doHeadRequest(URL url) throws IOException {
        return null;
    }

    @Override
    public HttpResponse doGetRequest(URL url) throws IOException {
        return null;
    }

    @Override
    public HttpResponse doHeadRequest(URL url, boolean b) throws IOException {
        return null;
    }

    @Override
    public HttpResponse doGetRequest(URL url, boolean b) throws IOException {
        return null;
    }

    @Override
    public HttpResponse doHeadRequest(URL url, String[] strings, String[] strings1) throws IOException {
        return null;
    }

    @Override
    public HttpResponse doGetRequest(URL url, String[] strings, String[] strings1) throws IOException {
        return null;
    }

    @Override
    public HttpResponse doHeadRequest(URL url, String[] strings, String[] strings1, boolean b) throws IOException {
        return null;
    }

    @Override
    public HttpResponse doGetRequest(URL url, String[] strings, String[] strings1, boolean b) throws IOException {
        return null;
    }

    public String getRequestURI() {
        return requestURI;
    }
}
