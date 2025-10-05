package DesignMode.Singleton;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Callable;
/**
 * @author Administrator
 * @date 2025/9/14 10:06
 * @see
 * @since JDK 17
 */
public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        FutureTask<Singleton2> futureTask = new FutureTask<Singleton2>(Singleton2::getInstance);
//        FutureTask<Singleton2> futureTask2 = new FutureTask<Singleton2>(Singleton2::getInstance);
//
//        Thread thread1 = new Thread(futureTask,"1");
//        Thread thread2 = new Thread(futureTask2);
//        thread1.start();
//        thread2.start();
//        System.out.println(futureTask.get()==futureTask2.get());

        Singleton3 singleton3 = Singleton3.getInstance();




    }
}
