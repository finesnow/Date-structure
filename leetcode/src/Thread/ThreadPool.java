package Thread;

import java.util.concurrent.*;

/**
 * @author Administrator
 * @date 2025/9/13 10:38
 * @see
 * @since JDK 17
 * @Description:
 */
public class ThreadPool {
    public  static int   target = 100;
    /**
     * flag为true时 thread1执行 否则2执行
     */
    public  static boolean flag = true;
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        //自定义线程池时需要指定的参数
        //核心线程数  需要维持的最小的线程数    最大线程数   空闲线程存活时间  时间单位  阻塞队列（线程较多时的排队执行方案）

//        executorService.submit(new MyCallable());
//        executorService.submit(new MyCallable());
//
//        //关闭线程池 线程池如果不关闭 将持续等待新线程的到来 程序不会结束
//        executorService.shutdown();


    }
}
