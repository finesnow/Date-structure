package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @date 2025/9/13 09:47
 * @see
 * @since JDK 17
 */
public class MyCallable implements Callable<String> {
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    @Override
    public String call()  {

        while (true)
        {
            try {
                lock.lock();
                if (ThreadPool.target>0)
                {
                    ThreadPool.target--;
                    System.out.println(Thread.currentThread().getName()+"修改了target:" + ThreadPool.target);
                }
                else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
        return null;
    }
}
