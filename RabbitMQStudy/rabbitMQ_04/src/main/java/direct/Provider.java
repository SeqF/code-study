package direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Provider {

    public static void main(String[] args) throws IOException, TimeoutException {

        //获取连接
        try (Connection connection = RabbitMQUtils.getConnection();
             //获取连接通道对象
             Channel channel = connection.createChannel()) {

            //通过通道声明交换机
            channel.exchangeDeclare("logs_direct", "direct");

            //发送消息
            String routingkey = "error";
            String message="这是direct模型发布的基于route key：[" + routingkey + "]发送的消息";
            channel.basicPublish("logs_direct", routingkey, null, message.getBytes());
        }

    }
}
