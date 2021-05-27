package thread;

public class demo1 {
    public static void main(String[] args) {
        demo1();
    }

    private static void demo1() {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("A");
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("B");
            }
        });
        A.start();
        B.start();
    }
    private static void printNumber(String threadName) {
        int i=0;
        while (i++ < 3) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " print: " + i);
        }
    }

}
class HelloWorld {

    public void hello(int n) {
        // @todo
        for(int i = 0 ; i <= n ; i++){
            System.out.print("Hello");
        }
    }

    public void world(int n) {
        // @todo
        for(int i = 0 ; i <= n ; i++){
            System.out.println("World");

        }
    }

}
