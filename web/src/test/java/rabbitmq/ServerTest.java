package rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.QueueingConsumer;
import org.junit.Test;

/**
 * @author: jianyu.lin  Date: 16-8-13.
 */
public class ServerTest {

    private Connection connection;
    private Channel channel;
    private Consumer consumer;

    public ServerTest init() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("rpc_user");
        factory.setPassword("rpcme");
        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.exchangeDeclare("rpc", "direct");
        channel.queueDeclare("ping", false, false, false, null);
        channel.queueBind("ping", "rpc", "ping");

        consumer = new QueueingConsumer(channel);
        channel.basicConsume("ping", false, "ping", consumer);

        System.out.println("Waiting for RPC calls");
        return this;
    }

    @Test
    public void serverTest() throws Exception {
        ServerTest serverTest = new ServerTest().init();
    }
}
