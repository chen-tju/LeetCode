package reflect;

import reflect.domain.Person;

import java.lang.reflect.Field;

public class ReflectDemo2 {

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
        /*1. 获取成员变量们
			* Field[] getFields() ：获取所有public修饰的成员变量
			* Field getField(String name)   获取***指定名称***的 public修饰的成员变量

			* Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
			* Field getDeclaredField(String name)
         */
        Field[] fields = personClass.getFields();

        Field a = personClass.getField("a");
        //获取成员变量a的值
        Person person = new Person();
        Object o = a.get(person);//--传一个对象进去
        System.out.println(o);

        a.set(person, "chen");
        System.out.println(person);

        System.out.println("------------------");
        Field[] declaredFields = personClass.getDeclaredFields();//获取所有的成员变量
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        //反射面前没有公用私有----私有会IllegalAccessException
        Field d = personClass.getDeclaredField("d");
        //忽略访问权限修饰符的安全检查
        d.setAccessible(true);//暴力反射
        Object o1 = d.get(person);
        System.out.println(o1);


    }


}
