import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Test_1 {
    public static void main(String[] args) {
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");

        System.out.println(str5.equals(str3));
        System.out.println(str5 == str3);
        System.out.println(str5.intern() == str3);
        System.out.println(str5.intern() == str4);
        System.out.println(str5.intern() == str4.intern());
        /**
         *  第一、str5.equals(str3)这个结果为true，不用太多的解释，因为字符串的值的内容相同。
         *  第二、str5 == str3对比的是引用的地址是否相同，由于str5采用new String方式定义的，所以地址引用一定不相等。所以结果为false。
         *  第三、当str5调用intern的时候，会检查字符串池中是否含有该字符串。由于之前定义的str3已经进入字符串池中，所以会得到相同的引用。
         *
         */
        System.out.println("------------------------------------");

        String a = new String("ab");
        String b = new String("ab");
        String c = "ab";
        String d = "a" + "b";
        String e = "b";
        String f = "a" + e;

        System.out.println(b.intern() == a);//采用new 创建的字符串对象不进入字符串池
        System.out.println(b.intern() == c);
        /**
         * 字符串相加的时候，都是静态字符串的结果会添加到字符串池，如果其中含有变量（如f中的e）则不会进入字符串池中。
         * 但是字符串一旦进入字符串池中，就会先查找池中有无此对象。如果有此对象，则让对象引用指向此对象。
         * 如果无此对象，则先创建此对象，再让对象引用指向此对象。
         */
        System.out.println(b.intern() == d);
        System.out.println(b.intern() == f);//
        System.out.println(b.intern() == a.intern());
        System.out.println(b.intern() == f.intern());

        System.out.println("--------------- equal及== ---------------------");

        String w = "ab";
        String q = "c";
        String r = "a" + "b" + "c";
        String t = w + q;

        System.out.println(r == t);


        int n1 = 1;
        int n2 = 2;
        System.out.println(n1 | n2);


    }
}
