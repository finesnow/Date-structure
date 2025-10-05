package Thread;

/**
 * @author Administrator
 * @date 2025/9/17 20:43
 * @see
 * @since JDK 17
 * 测试PV 操作 P令信号量减少（可能阻塞）  V令信号量增加  （唤醒）  P于V必须都是原子的
 */
public class TestPV {

    private static int Semaphore = 0;
    //希望target先变小再变大 最小值为0
    private static int  target = 10;

    public static void main(String[] args) throws InterruptedException {
        TestPV testPV = new TestPV();
        Thread reader = new Thread(new reader(testPV));
        Thread writer = new Thread(new writer(testPV));
        reader.start();
        writer.start();

        Thread.sleep(1000);
        System.out.println(target);
    }

    public void read() throws InterruptedException {
        P();
       target = target + 20;
    }

    public void write() throws InterruptedException {
        target = Math.max(0,target-15);
        V();
    }

    public synchronized void P() throws InterruptedException {
        Semaphore--;
        if (Semaphore < 0)
            this.wait();
    }

    public synchronized void V() {
        Semaphore++;
        this.notify();
    }

    static class reader implements Runnable {
        private final TestPV testPV;

        public reader(TestPV testPV) {
            this.testPV = testPV;
        }

        @Override
        public void run() {
            try {
                testPV.read();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class writer implements Runnable {
        private final TestPV testPV;

        public writer(TestPV testPV) {
            this.testPV = testPV;
        }

        @Override
        public void run() {
            try {
                testPV.write();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

