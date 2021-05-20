package reflect;

import reflect.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectDemo4 {

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
        /*		3. 获取成员方法们：
         * Method[] getMethods()
         * Method getMethod(String name, 类<?>... parameterTypes)

         * Method[] getDeclaredMethods()
         * Method getDeclaredMethod(String name, 类<?>... parameterTypes)
         *
         */

        Method eat = personClass.getMethod("eat");
        Person person = new Person();
        eat.invoke(person);//invoke方法

        Method eat1 = personClass.getMethod("eat", String.class);
        eat1.invoke(person, "粑粑");

        System.out.println("----------------");
        Method[] methods = personClass.getMethods();//所有方法不只看到的，还有Object的方法
        for (Method method : methods) {
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
        }

        eat.setAccessible(true);//暴力反射

        //获取类名
        String name = personClass.getName();
        System.out.println(name);

    }
}
