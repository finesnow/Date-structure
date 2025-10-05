package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @date 2025/9/15 15:00
 * @see
 * @since JDK 17
 *
 */
public class MyThreadPool {
    private MyThreadPool() {    //防止反射破坏
        if (MyThreadPoolHolder.flag)
            throw new RuntimeException("非法访问");
    }

    public static MyThreadPool getInstance() {
        return MyThreadPoolHolder.MY_THREAD_POOL;
    }
    public void submitTask(Runnable runnable) {
        MyThreadPoolHolder.THREAD_POOL_EXECUTOR.submit(runnable);
    }
    public void shutdown(){
        MyThreadPoolHolder.THREAD_POOL_EXECUTOR.shutdown();
    }
    public Object readResolve() { //防止反序列化破坏
        return getInstance();
    }



    private static class MyThreadPoolHolder {
        private static final MyThreadPool MY_THREAD_POOL;
        private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR;
        private static final boolean flag;
        static {
            MY_THREAD_POOL = new MyThreadPool();
            flag = true;
            Properties properties = new Properties();
            try {
                properties.load(new FileInputStream("threadPool.properties"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(Integer.parseInt(properties.getProperty("corePoolSize"))
                    , Integer.parseInt(properties.getProperty("maxPoolSize"))
                    , Long.parseLong(properties.getProperty("aliveTime"))
                    , TimeUnit.SECONDS
                    , new ArrayBlockingQueue<>(Integer.parseInt(properties.getProperty("queueSize")))
                    , new ThreadPoolExecutor.CallerRunsPolicy());
        }
    }

}
