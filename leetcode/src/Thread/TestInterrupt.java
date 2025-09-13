package Thread;

import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @date 2025/9/13 20:29
 * @see
 * @since JDK 17
 */
public class TestInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("working");
                    if (Thread.currentThread().isInterrupted())
                        break;
                }
            }
        },"worker");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
