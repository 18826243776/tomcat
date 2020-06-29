package com.yue.connector;


import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by 千里明月 on 2018/8/26.
 */
public class HttpProcessor {

    HttpRequest request = null;
    HttpResponse response=null;

    public HttpProcessor(HttpConnector httpConnector) {

    }

    public void process(Socket socket) {
        SocketInpuStream input = null;
        OutputStream output = null;
        try {
            input = new SocketInpuStream(socket.getInputStream(), 2048);
            output = socket.getOutputStream();
            request = new HttpRequest(input);
            response=new HttpResponse(output);
            response.setRequest(request);
            response.setHeader("Server","Servlet Container");
            parseRequest(input,output);
            parseHeaders(input);

            if (request.getRequestURI().startsWith("/servlet/")){
                ServletProcessor processor = new ServletProcessor();
                processor.process(request,response);
            }else {
                StaticResourcesProcessor processor = new StaticResourcesProcessor();
                processor.process(request,response);
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseHeaders(SocketInpuStream input) {

    }

    private void parseRequest(SocketInpuStream input, OutputStream output) {
    }

}
