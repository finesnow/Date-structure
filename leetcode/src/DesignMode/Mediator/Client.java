package DesignMode.Mediator;

import lombok.Getter;

/**
 * @author Administrator
 * @date 2025/9/15 19:49
 * @see
 * @since JDK 17
 */

public abstract class Client {
    protected int clientID;
    protected  Server server;

    public Client(int clientID, Server server) {
        this.clientID = clientID;
        this.server = server;
    }

    abstract  void  receive(Message message);

    abstract  void newMessage(int target);
}
