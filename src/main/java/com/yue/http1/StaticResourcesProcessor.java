package com.yue.http1;

import java.io.IOException;

public class StaticResourcesProcessor {

    public void process(Request request,Response response){
        try{
            response.setStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
