package Thread;

import java.util.concurrent.*;

/**
 * @author Administrator
 * @date 2025/9/13 10:38
 * @see
 * @since JDK 17
 */
public class ThreadPool {
    public  static int   target = 100;
    /**
     * flag为true时 thread1执行 否则2执行
     */
    public  static boolean flag = true;
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //指定线程池大小
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new MyCallable());
        executorService.submit(new MyCallable());

        //关闭线程池 线程池如果不关闭 将持续等待新线程的到来 程序不会结束
        executorService.shutdown();


    }
}
