import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test_synchonized {
//    public static void main(String[] args) {
//        //使用ExecutorService执行两个线程，调用同一个对象的同步代码块，两个线程会进行同步
//        //一个线程进入同步语句块时，另一个线程必须等待
//        SynchronizedExample e1 = new SynchronizedExample();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> e1.func1());
//        executorService.execute(() -> e1.func1());
//    }
//---结果：0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9

    public static void main(String[] args) {
        //两个线程调用不同对象的同步代码块，这两个线程不需要同步。两个线程交叉执行。
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e2.func1());
    }
//---结果：0 0 1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9

}



class SynchronizedExample {
    public void func1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
