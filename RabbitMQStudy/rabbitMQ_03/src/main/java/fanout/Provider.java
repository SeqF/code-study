package fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Provider {

    public static void main(String[] args) throws IOException, TimeoutException {


        try (
                //获取连接对象
                Connection connection = RabbitMQUtils.getConnection();
                Channel channel = connection.createChannel()) {

            //将通道声明指定交换机
            //参数：
            //exchange:  交换机名称
            //type: 交换机类型"
            channel.exchangeDeclare("logs", "fanout");

            //发送消息
            channel.basicPublish("logs", "", null, "fanout type message".getBytes("UTF-8"));
        }
    }
}
