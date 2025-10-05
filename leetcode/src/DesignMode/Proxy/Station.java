package DesignMode.Proxy;

/**
 * @author Administrator
 * @date 2025/9/15 21:02
 * @see
 * @since JDK 17
 */
public class Station implements TicketOffice{
    @Override
    public void sellTickets() {
        System.out.println("从火车站处购买一张票");
    }
}
