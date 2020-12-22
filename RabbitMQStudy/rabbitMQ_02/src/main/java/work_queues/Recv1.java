package work_queues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv1 {

    private final static String QUEUE_NAME = "work";

    public static void main(String[] args) throws IOException, TimeoutException {


        Connection connection = RabbitMQUtils.getConnection();
        final Channel channel = connection.createChannel();

        //每次只分配一个消息
        channel.basicQos(1);
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);


        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("消费者-1 " + message);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
        };

        //将消息自动确认改为 false
        channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> {
        });

    }

}
