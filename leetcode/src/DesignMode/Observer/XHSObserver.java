package DesignMode.Observer;

/**
 * @author Administrator
 * @date 2025/9/9 22:18
 * @see
 * @since JDK 17
 */
public class XHSObserver implements Observer{
    @Override
    public void update(String message) {
        System.out.println("小红书新闻板块更新"+message);
    }
}
