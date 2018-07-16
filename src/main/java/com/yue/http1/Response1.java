package com.yue.http1;


import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.*;
import java.util.Locale;

public class Response1 implements ServletResponse {
    private OutputStream outputStream;
    private Request1 request;
    private static final int BUFFER_SIZE = 2048;

    public Response1(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public Response1(OutputStream os, Request1 request) {
        this.outputStream = os;
        this.request = request;
    }

    public void setStaticResource() throws IOException {
        String uri = request.getUri();
        if (uri==null){
            handleExce();
        }
        File file = new File(new File(HttpServer1.WEB_ROOT, "/static"), uri);
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
            outputStream.write(sb.toString().getBytes("UTF-8"));
        } catch (FileNotFoundException e) {
            handleExce();
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }

    private void handleExce(){
        String errMessage = "HTTP/1.1 404 File Not Found \r\n" +
                "Content-Type:text/html\r\n" +
                "Content-Length:23\r\n" +
                "\r\n" +
                "<h1>File Not Found</h1>";
        try {
            outputStream.write(errMessage.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getCharacterEncoding() {
        return null;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return null;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return null;
    }

    @Override
    public void setCharacterEncoding(String charset) {

    }

    @Override
    public void setContentLength(int len) {

    }

    @Override
    public void setContentLengthLong(long len) {

    }

    @Override
    public void setContentType(String type) {

    }

    @Override
    public void setBufferSize(int size) {

    }

    @Override
    public int getBufferSize() {
        return 0;
    }

    @Override
    public void flushBuffer() throws IOException {

    }

    @Override
    public void resetBuffer() {

    }

    @Override
    public boolean isCommitted() {
        return false;
    }

    @Override
    public void reset() {

    }

    @Override
    public void setLocale(Locale loc) {

    }

    @Override
    public Locale getLocale() {
        return null;
    }
}
