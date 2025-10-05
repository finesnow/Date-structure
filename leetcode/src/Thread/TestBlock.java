package Thread;

import java.util.Scanner;

/**
 * @author Administrator
 * @date 2025/9/17 09:16
 * @see
 * @since JDK 17
 */
public class TestBlock {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.getState());
    }
}
