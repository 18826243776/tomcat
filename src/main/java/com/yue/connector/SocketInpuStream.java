package com.yue.connector;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 千里明月 on 2018/8/26.
 */
public class SocketInpuStream extends InputStream {

    public SocketInpuStream() {

    }

    public SocketInpuStream(InputStream inputStream, int i) {
        byte[] bytes = new byte[i];

    }

    @Override
    public int read() throws IOException {
        return 0;
    }

    public void readRequestLine(){

    }
    public void readHeader(){

    }

}
