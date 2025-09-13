package Thread;

/**
 * @author Administrator
 * @date 2025/9/12 11:18
 * @see
 * @since JDK 17
 */
public class MyThread implements Runnable{

    public static ThreadLocal<Long> threadID = new ThreadLocal<>();
    @Override
    public void run() {
        threadID.set(Thread.currentThread().getId());
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(threadID.get());
    }
}
