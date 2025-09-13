package Thread;

import org.junit.Test;

import java.util.Random;

/**
 * @author Administrator
 * @date 2025/9/12 11:18
 * @see
 * @since JDK 17
 */
public class TestThread {
    public static void main(String[] args) {
        ResourceArea area = new ResourceArea();
        Random random = new Random(System.currentTimeMillis());

//        Thread producerThread = new Thread(new Producer(area));
//        Thread consumerThread = new Thread(new Consumer(area));
//        producerThread.start();
//        consumerThread.start();

        //多个消费者和生产者的情况
        new Thread(new Producer(area)).start();
        new Thread(new Producer(area)).start();
        new Thread(new Producer(area)).start();

        new Thread(new Consumer(area)).start();
        new Thread(new Consumer(area)).start();
        new Thread(new Consumer(area)).start();
    }


}
