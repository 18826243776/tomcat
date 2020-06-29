package com.yue.http1;

import javax.servlet.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * 解析请求
 */
public class Request1 implements ServletRequest{


    private InputStream inputStream;
    private String uri;

    public Request1(InputStream inputStream) {
        this.inputStream = inputStream;
        parseURI();
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
        System.out.println(sb.toString());
        String requestContent = sb.toString();
        int index1 = requestContent.indexOf(" ");
        if (index1 != -1) {
            int index2 = requestContent.indexOf(" ", index1 + 1);
            if (index1 < index2) {
                this.uri = requestContent.substring(index1 + 1, index2);
                System.out.println(this.uri);
                return this.uri;
            }
        }
        return null;
    }


    public String getUri() {
        return this.uri;
    }

    @Override
    public Object getAttribute(String s) {
        return null;
    }
    @Override
    public Enumeration<String> getAttributeNames() {
        return null;
    }
    @Override
    public String getCharacterEncoding() {
        return null;
    }
    @Override
    public void setCharacterEncoding(String s) throws UnsupportedEncodingException {

    }
    @Override
    public int getContentLength() {
        return 0;
    }
    @Override
    public long getContentLengthLong() {
        return 0;
    }
    @Override
    public String getContentType() {
        return null;
    }
    @Override
    public ServletInputStream getInputStream() throws IOException {
        return null;
    }
    @Override
    public String getParameter(String s) {
        return null;
    }
    @Override
    public Enumeration<String> getParameterNames() {
        return null;
    }
    @Override
    public String[] getParameterValues(String s) {
        return new String[0];
    }
    @Override
    public Map<String, String[]> getParameterMap() {
        return null;
    }
    @Override
    public String getProtocol() {
        return null;
    }
    @Override
    public String getScheme() {
        return null;
    }
    @Override
    public String getServerName() {
        return null;
    }
    @Override
    public int getServerPort() {
        return 0;
    }
    @Override
    public BufferedReader getReader() throws IOException {
        return null;
    }
    @Override
    public String getRemoteAddr() {
        return null;
    }

    @Override
    public String getRemoteHost() {
        return null;
    }

    @Override
    public void setAttribute(String name, Object o) {

    }

    @Override
    public void removeAttribute(String name) {

    }

    @Override
    public Locale getLocale() {
        return null;
    }

    @Override
    public Enumeration<Locale> getLocales() {
        return null;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String path) {
        return null;
    }

    @Override
    public String getRealPath(String path) {
        return null;
    }

    @Override
    public int getRemotePort() {
        return 0;
    }

    @Override
    public String getLocalName() {
        return null;
    }

    @Override
    public String getLocalAddr() {
        return null;
    }

    @Override
    public int getLocalPort() {
        return 0;
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public AsyncContext startAsync() throws IllegalStateException {
        return null;
    }

    @Override
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
        return null;
    }

    @Override
    public boolean isAsyncStarted() {
        return false;
    }

    @Override
    public boolean isAsyncSupported() {
        return false;
    }

    @Override
    public AsyncContext getAsyncContext() {
        return null;
    }

    @Override
    public DispatcherType getDispatcherType() {
        return null;
    }


}
