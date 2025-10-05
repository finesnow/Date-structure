package DesignMode.Mediator;

import java.util.HashMap;

/**
 * @author Administrator
 * @date 2025/9/15 19:49
 * @see
 * @since JDK 17
 */
public class CenterServer implements Server {
    private HashMap<Integer,Client> clientHashMap = new HashMap<>();

    @Override
    public void reviveMessage(Message message) {
            if (clientHashMap.containsKey(message.getTargetId()))
            {
                clientHashMap.get(message.getTargetId()).receive(message);
            }
    }
    @Override
    public void append(Client client){
        clientHashMap.put(client.clientID,client);
    }

    public static void main(String[] args) {
            Server server = new CenterServer();
            Client qqClient = new QQClient(12345,server);
            Client qqClient1 = new QQClient(12343,server);
            Client qqClient2 = new QQClient(12323,server);
            server.append(qqClient);
            server.append(qqClient1);
            server.append(qqClient2);

            qqClient.newMessage(12323);

    }
}
