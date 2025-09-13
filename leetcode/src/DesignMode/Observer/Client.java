package DesignMode.Observer;

/**
 * @author Administrator
 * @date 2025/9/9 22:19
 * @see
 * @since JDK 17
 */
public class Client {
    public static void main(String[] args) {
        Observable observable = new PublicNews();
        observable.attach(new WeiboObserver());
        observable.attach(new XHSObserver());
        observable.execute();
    }
}
