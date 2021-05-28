package thread;

//两个不同的线程将会共用一个 HelloWorld 实例。其中一个线程将会调用 hello() 方法，另一个线程将会调用 world() 方法，
// 请设计修改程序，以确保 "HelloWorld" 被输出 n 次。

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintHelloWorld {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        HelloWorld helloWorld = new PrintHelloWorld().new HelloWorld(lock,conditionA,conditionB);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                helloWorld.hello(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                helloWorld.world(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    //评测题目

    class HelloWorld {
//        private Lock lock = new ReentrantLock();
//        private Condition condition = lock.newCondition();
        private Lock lock;
        private Condition conditionA;
        private Condition conditionB;

        public HelloWorld(Lock lock, Condition conditionA, Condition conditionB) {
            this.lock = lock;
            this.conditionA = conditionA;
            this.conditionB = conditionB;
        }

        public void hello(int n) throws InterruptedException {
            // @todo
            lock.lock();
            try{
                for(int i = 0 ; i <= n ; i++){
                    System.out.print("Hello");
                    conditionB.signalAll();
                    conditionA.await();
                }
            }  finally {
                lock.unlock();
            }

        }

        public void world(int n) throws InterruptedException {
            // @todo
            lock.lock();
            try{
                for(int i = 0 ; i <= n ; i++){
                    System.out.print("World");
                    conditionA.signalAll();
                    conditionB.await();
                }
            }  finally {
                lock.unlock();
            }

        }

    }
}
