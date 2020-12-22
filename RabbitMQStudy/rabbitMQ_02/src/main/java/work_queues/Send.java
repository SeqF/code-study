package work_queues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {

    private final static String QUEUE_NAME = "work";

    public static void main(String[] args) throws IOException, TimeoutException {

        try (
                //获取连接对象
                Connection connection = RabbitMQUtils.getConnection();
                //获取通道对象
                Channel channel = connection.createChannel()) {

            //通过通道声明队列
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);

            String message = "hmbiss";
            for (int i = 0; i < 1000; i++) {
                //发布消息
                channel.basicPublish("", QUEUE_NAME, null, (message + i).getBytes());
            }
        }
    }
}
