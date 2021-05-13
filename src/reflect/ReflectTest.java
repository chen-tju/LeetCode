package reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 *     框架类
 */

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //可以创建任意类的对象，可以执行任意方法

//        Person person = new Person();
//        person.eat();
        /**
         * 前提：不能改变该类的任何代码，可以创建任意类的对象，可以执行任意方法
         */

        //1、加载配置文件

        //创建Properties对象
        Properties properties = new Properties();
        //加载配置文件，转换为一个集合
        //获取class目录下的配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader();//类加载器
        InputStream resourceAsStream = classLoader.getResourceAsStream("reflect/pro.properties");
        properties.load(resourceAsStream);

        //2、获取配置文件中定义的数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        //3、加载该类进内存
        Class aClass = Class.forName(className);

        //4、创建对象
        Object o = aClass.newInstance();

        //5、获取方法对象
        Method method = aClass.getMethod(methodName);

        //6、执行方法
        method.invoke(o);


    }
}
