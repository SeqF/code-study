package direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Customer1 {

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        //通道声明交换机以及交换的类型
        channel.exchangeDeclare("logs_direct", "direct");

        //创建一个临时队列
        String queue = channel.queueDeclare().getQueue();

        //基于route key绑定队列和交换机
        channel.queueBind(queue, "logs_direct", "error");
        //消费消息
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("消费者1： " + message);
        };
        channel.basicConsume(queue, true, deliverCallback, consumerTag -> {
        });
    }
}
