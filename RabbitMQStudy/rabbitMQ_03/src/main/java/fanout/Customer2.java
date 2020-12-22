package fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import utils.RabbitMQUtils;

import java.io.IOException;

public class Customer2 {

    public static void main(String[] args) throws IOException {

        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        //通道绑定交换机
        channel.exchangeDeclare("logs", "fanout");

        //临时队列
        String queue = channel.queueDeclare().getQueue();

        //绑定交换机和队列
        channel.queueBind(queue, "logs", "");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("消费者-2 " + message);
        };

        channel.basicConsume(queue, true, deliverCallback, consumerTag -> {
        });
    }
}
