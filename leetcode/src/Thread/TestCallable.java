package Thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Administrator
 * @date 2025/9/13 09:56
 * @see
 * @since JDK 17
 */
public class TestCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> futureTask = new FutureTask<String>(new MyCallable());
        FutureTask<String> futureTask2 = new FutureTask<String>(new MyCallable());
        Thread thread1 = new Thread(futureTask,"futureTask111");
        Thread thread2 = new Thread(futureTask2,"futureTask222");

        thread1.start();
        thread2.start();

        System.out.println(futureTask.get());

    }
}
