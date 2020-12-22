package topics;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import utils.RabbitMQUtils;

import java.io.IOException;

public class Customer2 {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("topics", "topic");

        String queue = channel.queueDeclare().getQueue();

        String routekey = "user.#";
        channel.queueBind(queue, "topics", routekey);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("消费者2： " + message);
        };
        channel.basicConsume(queue, true, deliverCallback, consumerTag -> {
        });

    }
}
