package Thread;

import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @date 2025/9/13 16:01
 * @see
 * @since JDK 17
 */
public class TestJoin {


    public static void main(String[] args) {

        Object object = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (object) {
                        System.out.println("thread1");
                    }
                }

            }
        }, "thread1");

        Thread thread2 = new Thread(() -> {

            for (int i = 0; i < 50; i++) {
                synchronized (object) {
                    System.out.println("thread2 " + i);
                    if (i == 20) {
                        try {
                            thread1.join();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }, "thread2");

        thread1.start();
        thread2.start();

    }


}
