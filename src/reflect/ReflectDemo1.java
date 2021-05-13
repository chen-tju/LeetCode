package reflect;

import reflect.domain.Person;

public class ReflectDemo1 {
    /*
    获取class对象的三种方式：
	1、Source源码阶段：Class.forName("全类名")
		----将字节码文件加载进内存，返回Class对象
	2、Class类对象阶段：类名.class
		----通过类名的属性class获取
	3、Runtime运行时阶段：对象.getClass()
		----getClass()方法封装在Object类中
     */
    public static void main(String[] args) throws ClassNotFoundException {

        //1、Class.forName("全类名")

        Class cls1 = Class.forName("reflect.domain.Person");
        System.out.println(cls1);//class reflect.domain.Person

        //2、类名.class
        Class cls2 = Person.class;
        System.out.println(cls2);

        //3、对象.getClass()
        Person person = new Person();
        Class cls3 = person.getClass();
        System.out.println(cls3);

        //==比较三个对象----->同一个字节码文件(*.class)在一次程序运行过程中，只会被加载一次，不论通过哪种方式获取的class对象都是同一个。
        System.out.println(cls1 == cls2);//true
        System.out.println(cls3 == cls2);// true

    }
}
