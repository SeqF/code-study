package direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Customer2 {

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        //声明交换机，以及交换机类型 direct
        channel.exchangeDeclare("logs_direct", "direct");
        //绑定一个临时队列
        String queue = channel.queueDeclare().getQueue();
        //临时队列和交换机绑定
        channel.queueBind(queue, "logs_direct", "error");
        channel.queueBind(queue, "logs_direct", "info");
        channel.queueBind(queue, "logs_direct", "warning");


        //消费消息
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("消费者2： " + message);
        };
        channel.basicConsume(queue, true, deliverCallback, consumerTag -> {
        });

    }
}
