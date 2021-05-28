package Test;

public class Test_static {

    static {
        i = 0;
        //System.out.println(i);
    }

    static int i = 9;

    //测试接口
    public abstract interface mn{
        public default void get(){

        }
    }

    interface mm{
        static void get(){

        }

    }
    abstract class Test{
        abstract void get();
    }
}
