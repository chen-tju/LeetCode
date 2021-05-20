package reflect;

import reflect.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectDemo3 {

    /*
    * 获取功能：
		1. 获取成员变量们
			* Field[] getFields() ：获取所有public修饰的成员变量
			* Field getField(String name)   获取***指定名称***的 public修饰的成员变量

			* Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
			* Field getDeclaredField(String name)
		2. 获取构造方法们
			* Constructor<?>[] getConstructors()
			* Constructor<T> getConstructor(类<?>... parameterTypes)

			* Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
			* Constructor<?>[] getDeclaredConstructors()
		3. 获取成员方法们：
			* Method[] getMethods()
			* Method getMethod(String name, 类<?>... parameterTypes)

			* Method[] getDeclaredMethods()
			* Method getDeclaredMethod(String name, 类<?>... parameterTypes)

		4. 获取全类名
			* String getName()
     */
    public static void main(String[] args) throws Exception {
        //0.获取Person的class对象
        Class personClass = Person.class;
        /*2. 获取构造方法们
         * Constructor<?>[] getConstructors()
         * Constructor<T> getConstructor(类<?>... parameterTypes)

         * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
         * Constructor<?>[] getDeclaredConstructors()
         */
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);

        //用来创建对象
        Object zhang = constructor.newInstance("zhang", 34);
        System.out.println(zhang);

        System.out.println("---------------");
        Constructor constructor1 = personClass.getConstructor();
        System.out.println(constructor1);

        //用来创建对象
        Object er = constructor1.newInstance();
        System.out.println(er);

        Object o = personClass.newInstance();//空参构造创建对象
        System.out.println(o);

        //暴力反射
        constructor1.setAccessible(true);

    }


}
