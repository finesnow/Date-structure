package Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * @date 2025/9/17 21:14
 * @see
 * @since JDK 17
 * 模拟读写锁
 */
public class ReadWriteLock {

    //对读者进行计数  如果无人再读  占有锁 不允许写 如有有人在读 不必
    public  static   int count = 0;

    //读写互斥锁
    public static Lock readWritelock = new ReentrantLock();
    //读者专用的，维持count操作的原子化
    public static Lock reader = new ReentrantLock();
    //
    public static Lock writer = new ReentrantLock();



    static class reader implements Runnable {
        private final ReadWriteLock readWriteLock;
        public reader(ReadWriteLock readWriteLock) {
            this.readWriteLock = readWriteLock;
        }

        @Override
        public void run() {
            while (true)
            {
                try {
                    readWriteLock.read();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    static class writer implements Runnable {
        private final ReadWriteLock readWriteLock;

        public writer(ReadWriteLock readWriteLock) {
            this.readWriteLock = readWriteLock;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    readWriteLock.write();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void read() throws InterruptedException {

        writer.lock();
        reader.lock();
        if (count==0)
            readWritelock.lock();
        count++;
        reader.unlock();

        writer.unlock();
        Thread.sleep(500);
        System.out.println(count + "reading now");


        reader.lock();
        count--;
        if (count==0)
            readWritelock.unlock();
        reader.unlock();
    }
    public void write() throws InterruptedException {
        writer.lock();
        readWritelock.lock();
        System.out.println(Thread.currentThread().getName() + "writing");
        readWritelock.unlock();
        writer.unlock();
    }

    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReadWriteLock();

        new Thread(new writer(readWriteLock),"w1").start();
        new Thread(new writer(readWriteLock),"w2").start();
        new Thread(new writer(readWriteLock),"w3").start();
        new Thread(new reader(readWriteLock),"r1").start();
        new Thread(new reader(readWriteLock),"r2").start();
        new Thread(new reader(readWriteLock),"r3").start();

    }
}

