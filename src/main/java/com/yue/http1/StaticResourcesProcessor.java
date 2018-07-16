package com.yue.http1;

import java.io.IOException;

public class StaticResourcesProcessor {

    public void process(Request1 request1, Response1 response1){
        try{
            response1.setStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
