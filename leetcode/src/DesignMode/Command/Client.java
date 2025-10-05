package DesignMode.Command;


import Utils.MyThreadPool;

import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @date 2025/9/15 18:52
 * @see
 * @since JDK 17
 */
public class Client {

    public static void main(String[] args) {

        List<String> dishes = Arrays.asList("红烧狮子头","麻婆豆腐","麻辣鸡丁");
        Chef chef  = new Chef("王大厨");
        Cleaner cleaner = new Cleaner("小李");

        CleanCommand cleanCommand = new CleanCommand(12306, cleaner);
        OrderCommand orderCommand = new OrderCommand(dishes, 10265, chef);

        MyThreadPool.getInstance().submitTask(cleanCommand);
        MyThreadPool.getInstance().submitTask(orderCommand);
        MyThreadPool.getInstance().shutdown();

    }


}
