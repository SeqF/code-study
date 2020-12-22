import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

//生产者P
public class Send {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {

        //创建连接mq的连接工厂对象
        ConnectionFactory factory = new ConnectionFactory();
        //设置连接rabbit的主机
        factory.setHost("120.79.33.152");
        //设置端口号
        factory.setPort(5672);
        //设置连接哪个虚拟主机
        factory.setVirtualHost("/icarus");
        //设置访问虚拟主机的用户名密码
        factory.setUsername("icarus");
        factory.setPassword("123456");

        //Connection和Channel都能自动关闭资源，所以放入try-with-resources中
        try (    //获取连接对象
                 Connection connection = factory.newConnection();
                 //获取连接中的通道
                 Channel channel = connection.createChannel()) {

            //通道绑定 对应消息队列
            //queue: 队列名称，如果队列不存在则自动创建
            //durable：定义队列是否持久化
            //exclusive：是否独占队列，即是否只能这个连接使用
            //autoDelete：是否在消费完成后自动删除队列
            //arguments：额外参数
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);

            //发布消息
            String message= "hmbiss";
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        }
    }
}
