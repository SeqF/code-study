import com.rabbitmq.client.*;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("[x] Received " + message);
        };

        //消费消息
        //queue：消费哪个队列的消息
        //autoACK：开始消息的自动确认机制
        //param3：消费时的回调接口
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
            String tag = "vip";
        });


    }
}
