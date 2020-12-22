package topics;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Provider {

    public static void main(String[] args) throws IOException, TimeoutException {

        try ( Connection connection = RabbitMQUtils.getConnection();
                Channel channel = connection.createChannel()) {
            channel.exchangeDeclare("topics","topic");

            String routekey="user.save.find";
            String message="这里是topic动态路由模型,routekey:["+routekey+"]";
            channel.basicPublish("topics",routekey,null,message.getBytes());
        }
    }
}
