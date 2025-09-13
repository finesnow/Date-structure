package Thread;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @date 2025/9/12 17:09
 * @see
 * @since JDK 17
 */
public class ResourceArea {
    /**
     * 资源区最大容量
     */
    public final int MAX_CAPACITY = 1000;
    private final Random random = new Random(System.currentTimeMillis());

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private final Condition consumeCondition = lock.newCondition();
    private final Condition productCondition = lock.newCondition();
    /**
     * 资源区当前存量
     */
    public int products = 0;
    /**
     * flag = true 生产者执行
     * flag = false 消费者执行
     */
    public boolean flag = true;
    /**
     * @author dme
     * @date 2025/9/13 15:12
     * @return {@code }
     *   生产者同步方法
     **/
    public synchronized void product() {
        //未到area的执行时机 或者 资源区已满
        if (!flag || products >= MAX_CAPACITY) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getMessage());
            }
        }
        int yield = Math.min(random.nextInt(100, 200), MAX_CAPACITY - products);
        products += yield;
        System.out.println("生产了:" + yield + "资源区剩余:" + products);
        flag = false;
        notify();
    }
    /**
     * @author dme
     * @date 2025/9/13 15:12
     * @return {@code }
     *   消费者同步方法
     **/
    public synchronized void consume() {
        if (flag || products == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getMessage());
            }
        }
        int consume = Math.min(products, random.nextInt(100, 200));
        products -= consume;
        System.out.println("消费了:" + consume + "资源区剩余:" + products);
        if (products < MAX_CAPACITY) {
            flag = true;
            notify();
        }
    }
    /**
     * @author dme
     * @date 2025/9/13 15:14
     * @return {@code }
     *  加锁实现生产方法
     **/
    public void lockProduct() {
        try {
            lock.lock();
            //未到area的执行时机 或者 资源区已满
            if (!flag || products >= MAX_CAPACITY) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(e.getMessage());
                }
            }
            int yield = Math.min(random.nextInt(100, 200), MAX_CAPACITY - products);
            products += yield;
            System.out.println("生产了:" + yield + "资源区剩余:" + products);
            flag = false;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
    /**
     * @author dme
     * @date 2025/9/13 15:14
     * @return {@code }
     *     加锁实现消费方法
     **/


    public void lockConsume() {
        try {
            lock.lock();
            if (flag || products == 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(e.getMessage());
                }
            }
            int consume = Math.min(products, random.nextInt(100, 200));
            products -= consume;
            System.out.println("消费了:" + consume + "资源区剩余:" + products);
            if (products < MAX_CAPACITY) {
                flag = true;
                condition.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * @return {@code }
     * 如果有多个消费者，请使用此方法
     * @author dme
     * @date 2025/9/13 11:36
     **/
    public void consumeMoreThread() {
        try {
            lock.lock();
            if (flag || products == 0) {
                try {
                    consumeCondition.await();
                } catch (InterruptedException e) {

                    System.out.println(e.getMessage());
                }
            }
            int consume = Math.min(products, random.nextInt(100, 200));
            products -= consume;
            System.out.println("消费了:" + consume + "资源区剩余:" + products);
            if (products < MAX_CAPACITY) {
                flag = true;
                productCondition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * @return {@code }
     * 如果有多个生产者请使用此生产方法
     * @author dme
     * @date 2025/9/13 11:36
     **/
    public  void productMoreThread() {
        try {
            lock.lock();
            //未到area的执行时机 或者 资源区已满
            if (!flag || products >= MAX_CAPACITY) {
                try {
                    productCondition.await();
                } catch (InterruptedException e) {

                    System.out.println(e.getMessage());
                }
            }
            int yield = Math.min(random.nextInt(100, 200), MAX_CAPACITY - products);
            products += yield;
            System.out.println("生产了:" + yield + "资源区剩余:" + products);
            flag = false;
            consumeCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
