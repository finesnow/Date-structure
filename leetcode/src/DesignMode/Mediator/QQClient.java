package DesignMode.Mediator;

/**
 * @author Administrator
 * @date 2025/9/15 19:51
 * @see
 * @since JDK 17
 */
public class QQClient extends Client{

    public QQClient(int clientID, Server server) {
        super(clientID, server);
    }

    @Override
    public void receive(Message message) {
        System.out.println(clientID+"收到消息"+message.getMessage());
    }

    @Override
    void newMessage(int target) {
      server.reviveMessage(new Message("QQ消息",target));
    }
}
