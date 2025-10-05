package DesignMode.Mediator;

/**
 * @author Administrator
 * @date 2025/9/15 19:47
 * @see
 * @since JDK 17
 */
public interface Server {

    void reviveMessage(Message message);
    void append(Client client);
}
