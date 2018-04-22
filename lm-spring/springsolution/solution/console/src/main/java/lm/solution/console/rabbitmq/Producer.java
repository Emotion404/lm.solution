package lm.solution.console.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
//import com.rabbitmq.client.QueueingConsumer;
import lm.solution.common.rabbitmq.ConfigRabbitMQ;
import lm.solution.common.rabbitmq.MqConst;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    public void publishMsg001(){

        try {

            //创建连接工厂
            ConnectionFactory factory = new ConnectionFactory();

            //设置RabbitMQ相关信息
            factory.setHost(MqConst.HOST);
            factory.setPort(MqConst.PORT);
            factory.setUsername(MqConst.USER_NAME);
            factory.setPassword(MqConst.PASSWORD);

            //创建一个新的连接
            Connection connection = factory.newConnection();

            //创建一个通道
            Channel channel=connection.createChannel();

            //  声明一个队列
            /**
             * queueDeclare
             * 第一个参数表示队列名称、
             * 第二个参数为是否持久化（true表示是，队列将在服务器重启时生存）、
             * 第三个参数为是否是独占队列（创建者可以使用的私有队列，断开后自动删除）、
             * 第四个参数为当所有消费者客户端连接断开时是否自动删除队列、
             * 第五个参数为队列的其他参数
             * */
            channel.queueDeclare(MqConst.QUEUE_TEST,false,false,false,null);

            String message="Hello RabbitMQ";

            // 发送消息到队列中
            /**
             * basicPublish
             * 第一个参数为交换机名称、
             * 第二个参数为队列映射的路由key、
             * 第三个参数为消息的其他属性、
             * 第四个参数为发送信息的主体
             * */
            channel.basicPublish("",MqConst.QUEUE_TEST,null,message.getBytes("UTF-8"));
            System.out.println("Producer Send +'" + message + "'");

            //关闭通道和连接
            channel.close();
            connection.close();

        }catch (TimeoutException | IOException e){
            e.printStackTrace();
        }

    }

    public void pulishTask002(){

        try {

            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(MqConst.HOST);
            factory.setPort(MqConst.PORT);
            factory.setUsername(MqConst.USER_NAME);
            factory.setPassword(MqConst.PASSWORD);

            Connection connection = factory.newConnection();
            Channel channel=connection.createChannel();
            channel.queueDeclare(MqConst.QUEUE_TASK,true,false,false,null);

            // 分发信息
            for(int i=0;i<10;i++){
                String message="Hello RabbitMQ "+i;
                channel.basicPublish(
                        "",
                        MqConst.QUEUE_TASK,
                        MessageProperties.PERSISTENT_TEXT_PLAIN,
                        message.getBytes());
                System.out.println("NewTask send '"+message+"'");
            }

            //
            channel.close();
            connection.close();

        }catch (IOException | TimeoutException e){
            e.printStackTrace();
        }

    }

    public void publishFanout003(){

        try {

            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(MqConst.HOST);
            factory.setPort(MqConst.PORT);
            factory.setUsername(MqConst.USER_NAME);
            factory.setPassword(MqConst.PASSWORD);

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            // fanout表示分发，所有的消费者得到同样的队列信息
            channel.exchangeDeclare(MqConst.EXCHANGE_LOG,"fanout");

            // 分发信息
            for (int i=0;i<50;i++){
                String message="Hello World"+i;
                channel.basicPublish(MqConst.EXCHANGE_LOG,"",null,message.getBytes());
                System.out.println("EmitLog Sent '" + message + "'");
            }

            //
            channel.close();
            connection.close();

        }catch (IOException | TimeoutException e){
            e.printStackTrace();
        }

    }

    // 路由关键字
    private static final String[] routingKeys004={"info" ,"warning", "error"};
    public void publishDirect004(){

        try {

            ConnectionFactory factory = new ConnectionFactory();
            ConfigRabbitMQ.configConnectionFactory(factory);

            Connection connection = factory.newConnection();
            Channel channel=connection.createChannel();

            // 声明交换机
            // 注意是direct
            channel.exchangeDeclare(MqConst.EXCHANGE_DIRECT_LOG,"direct");

            // 发送信息
            for(String routingKey : routingKeys004){
                String message="RoutingSendDirect Send the message level:" + routingKey;
                channel.basicPublish(MqConst.EXCHANGE_DIRECT_LOG,routingKey,null,message.getBytes());
                System.out.println("RoutingSendDirect Send"+routingKey +"':'" + message);
            }

            //
            channel.close();
            connection.close();

        }catch (IOException | TimeoutException e){
            e.printStackTrace();
        }

    }

    /**
     * Topics
     * 这种应该属于模糊匹配
     * * ：可以替代一个词
     * #：可以替代0或者更多的词
     * */
    public void publishTopic005(){

        try {

            ConnectionFactory factory = new ConnectionFactory();
            ConfigRabbitMQ.configConnectionFactory(factory);

            Connection connection = factory.newConnection();
            Channel channel=connection.createChannel();

            // 声明一个匹配模式的交换机
            channel.exchangeDeclare(MqConst.EXCHANGE_TOPIC_LOG,"topic");

            // route key
            String[] routingkeys={
                    "quick.orange.rabbit",
                    "lazy.orange.elephant",
                    "quick.orange.fox",
                    "lazy.brown.fox",
                    "quick.brown.fox",
                    "quick.orange.male.rabbit",
                    "lazy.orange.male.rabbit"
            };

            // 发送消息
            for (String routekey :routingkeys){
                String message="From "+routekey+" routingKey' s message!";
                channel.basicPublish(MqConst.EXCHANGE_TOPIC_LOG,routekey,null,message.getBytes());
                System.out.println("TopicSend Sent '" + routekey + "':'" + message + "'");
            }

            //
            channel.close();
            connection.close();

        }catch (IOException | TimeoutException e){
            e.printStackTrace();
        }

    }

    private static int fib(int n){
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 1);
    }
    public void publishRpc006(){

        try {

            ConnectionFactory factory = new ConnectionFactory();
            ConfigRabbitMQ.configConnectionFactory(factory);

            Connection connection = factory.newConnection();
            Channel channel=connection.createChannel();
            channel.queueDeclare(MqConst.QUEUE_RPC,false,false,false,null);
            channel.basicQos(1);
//                QueueingConsumer consumer

        }catch (IOException |TimeoutException e){
            e.printStackTrace();
        }

    }

}
