package DesignMode.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 * @date 2025/9/15 21:09
 * @see
 * @since JDK 17
 */
public class StationProxyFactory {

    private Station station;

    public StationProxyFactory(Station station) {
        this.station = station;
    }

    public TicketOffice getProxy(){
        TicketOffice proxy = (TicketOffice) Proxy.newProxyInstance(station.getClass().getClassLoader(), station.getClass().getInterfaces()  ,new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("寻找有余票的火车站");
                method.invoke(station,args);
                System.out.println("帮忙指路");
                return null;
            }
        });
        return proxy;
    }
}
