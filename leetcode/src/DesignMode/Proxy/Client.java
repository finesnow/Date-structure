package DesignMode.Proxy;

/**
 * @author Administrator
 * @date 2025/9/15 21:05
 * @see
 * @since JDK 17
 */
public class Client {
    public static void main(String[] args) {

        StationProxyFactory factory = new  StationProxyFactory(new Station());
        factory.getProxy().sellTickets();
    }
}
