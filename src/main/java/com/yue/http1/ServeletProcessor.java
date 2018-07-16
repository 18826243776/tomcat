package com.yue.http1;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 千里明月 on 2018/7/16.
 */
public class ServeletProcessor {

    public void process(Request1 request, Response1 response)  {
        String uri = request.getUri();
        uri = uri.substring(uri.lastIndexOf("/")+1, uri.length() );
        File file = new File(HttpServer1.WEB_ROOT);
        List<File> files = searchDenotingFile(file, uri + ".class", new ArrayList<File>(16));
        if (files != null && files.size() > 1) {
            throw new RuntimeException("不能有两个一样的servlet");
        }
        if (files == null || files.size() == 0){
            throw new RuntimeException("找不到该servlet");
        }
        File file1 = files.get(0);
        try {

//            String filePah = file1.getCanonicalPath();
//            URL url = new URL("file", null, filePah);
//            URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
//            Class<?> servlet = classLoader.loadClass(uri+".class");
            ClassLoader classLoader =Thread.currentThread().getContextClassLoader();
            Class<?> servlet = classLoader.loadClass("com.yue.servlet."+uri);
            System.out.println(servlet);
            Method service = servlet.getMethod("service", ServletRequest.class, ServletResponse.class);
            Object o = servlet.newInstance();
            service.invoke(o, request, response);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static Class<?> loadClass(String fullClzName) {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(fullClzName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<File> searchDenotingFile(File file, String fileName, List<File> fileList) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    searchDenotingFile(file1, fileName, fileList);
                } else {
                    if (fileName.equals(file1.getName())) {

                        fileList.add(file1.getParentFile());
                    }
                }
            }
        }
        return fileList;
    }

}
