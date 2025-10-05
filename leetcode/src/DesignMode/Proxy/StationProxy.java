package DesignMode.Proxy;

/**
 * @author Administrator
 * @date 2025/9/15 21:03
 * @see
 * @since JDK 17
 */
public class StationProxy implements TicketOffice{
    private Station station;

    public StationProxy(Station station) {
        this.station = station;
    }
    @Override
    public void sellTickets() {
        System.out.println("寻找有余票的火车站");
        station.sellTickets();
        System.out.println("帮忙指路");
    }
}
