package com.yue.connector;

/**
 * Created by 千里明月 on 2018/8/26.
 */
public final class BootStrap {
    public static void main(String[] args) {
        HttpConnector connector = new HttpConnector();
        connector.start();
    }
}
