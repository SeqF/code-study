package work_queues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv2 {
    private final static String QUEUE_NAME = "work";

    public static void main(String[] args) throws IOException, TimeoutException {


        Connection connection = RabbitMQUtils.getConnection();
        final Channel channel = connection.createChannel();

        channel.basicQos(1);
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);


        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("消费者-2 " + message);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
        };

        channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> {
        });

    }
}
