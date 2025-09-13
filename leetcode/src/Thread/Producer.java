package Thread;

import java.util.Random;

/**
 * @author Administrator
 * @date 2025/9/12 16:58
 * @see
 * @since JDK 17
 */
public class Producer implements Runnable{
    private final ResourceArea area;

    public Producer(ResourceArea area) {
        this.area = area;
    }
    @Override
    public  void run() {
        for (int i = 0; i < 100; i++) {

      //      area.product();
      //      area.lockProduct();
            area.productMoreThread();
        }
    }
}
