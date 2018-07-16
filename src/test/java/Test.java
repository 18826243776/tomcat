import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by 千里明月 on 2018/7/16.
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException {
        // 第一种：获取类加载的根路径   D:\git\daotie\daotie\target\classes
        File f = new File(new Test().getClass().getResource("/").getPath());
//        System.out.println(f);


        // 第二种：获取项目路径    D:\git\daotie\daotie
        File directory = new File("");// 参数为空
        String courseFile = directory.getCanonicalPath();
//        System.out.println(courseFile);

        // 第五种：  获取所有的类路径 包括jar包的路径
//        System.out.println(System.getProperty("java.class.path"));

//        URL file = new URL("file", null, "D:\\ideahome\\tomcat");
//        URL[] urls = {file};
//        URLClassLoader loader = new URLClassLoader(urls);
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> test = systemClassLoader.loadClass("com.yue.servlet.PrimitiveServlet");
        System.out.println(test);
        Method service = test.getMethod("service", ServletRequest.class, ServletResponse.class);
        System.out.println(service);
    }
}
