package lm.solution.console.rabbitmq;

import com.rabbitmq.client.*;
import lm.solution.common.rabbitmq.ConfigRabbitMQ;
import lm.solution.common.rabbitmq.MqConst;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Customer {

    public void consume001() {

        try {

            // 创建连接工厂
            ConnectionFactory factory = new ConnectionFactory();

            //设置RabbitMQ地址
            factory.setHost(MqConst.HOST);
            factory.setPort(MqConst.PORT);
            factory.setUsername(MqConst.USER_NAME);
            factory.setPassword(MqConst.PASSWORD);

            //创建一个新的连接
            Connection connection = factory.newConnection();

            //创建一个通道
            Channel channel = connection.createChannel();

            //声明要关注的队列
            channel.queueDeclare(MqConst.QUEUE_TEST, false, false, false, null);
            System.out.println("Customer Waiting Received messages");

            // DefaultConsumer类实现了Consumer接口，通过传入一个频道，
            // 告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
            Consumer consumer = new DefaultConsumer(channel) {

                @Override
                public void handleDelivery(
                        String consumerTag,
                        Envelope envelope,
                        AMQP.BasicProperties properties,
                        byte[] body) throws IOException {

                    String message = new String(body, "UTF-8");
                    System.out.println("Customer Received '" + message + "'");

                }

            };

            //自动回复队列应答 -- RabbitMQ中的消息确认机制
            channel.basicConsume(MqConst.QUEUE_TEST, true, consumer);

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }

    }

    public void consumeTask002(boolean isEx) {

        try {

            final ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(MqConst.HOST);
            factory.setPort(MqConst.PORT);
            factory.setUsername(MqConst.USER_NAME);
            factory.setPassword(MqConst.PASSWORD);

            Connection connection = factory.newConnection();
            final Channel channel = connection.createChannel();

            channel.queueDeclare(MqConst.QUEUE_TASK, true, false, false, null);
            System.out.println("Worker1  Waiting for messages");

            // 每次从队列获取的数量
            /**
             * channel.basicQos(1);保证一次只分发一个
             * */
            channel.basicQos(1);

            final Consumer consumer = new DefaultConsumer(channel) {

                @Override
                public void handleDelivery(
                        String consumerTag,
                        Envelope envelope,
                        AMQP.BasicProperties properties,
                        byte[] body) throws IOException {

                    String message=new String(body,"UTF-8");
                    System.out.println("Worker1  Received '" + message + "'");

                    try{
                        if(isEx){
                            throw new Exception();
                        }
                        else {
                            doWork(message);
                        }
                    }catch (Exception e){
                        channel.abort();
                    }
                    finally {
                        System.out.println("Worker1 Done");
                        channel.basicAck(envelope.getDeliveryTag(),false);
                    }

                }

            };

            // 不自动回复队列应答 -- RabbitMQ中的消息确认机制
            /**
             * autoAck是否自动回复，
             * 如果为true的话，每次生产者只要发送信息就会从内存中删除，
             * 那么如果消费者程序异常退出，那么就无法获取数据，
             * 我们当然是不希望出现这样的情况，所以才去手动回复，
             * 每当消费者收到并处理信息然后在通知生成者。最后从队列中删除这条信息。
             * 如果消费者异常退出，如果还有其他消费者，
             * 那么就会把队列中的消息发送给其他消费者，如果没有，
             * 等消费者启动时候再次发送。
             * */
            channel.basicConsume(MqConst.QUEUE_TASK,false,consumer);

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }

    }
    private void doWork(String task){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void consumeFanout003(){

        try {

            ConnectionFactory factory = new ConnectionFactory();
            ConfigRabbitMQ.configConnectionFactory(factory);

            Connection connection = factory.newConnection();

            Channel channel=connection.createChannel();
            channel .exchangeDeclare(MqConst.EXCHANGE_LOG,"fanout");

            // 产生一个随机的队列名称
            String queueName=channel.queueDeclare().getQueue();
            // 对队列进行绑定
            channel.queueBind(queueName,MqConst.EXCHANGE_LOG,"");

            System.out.println("ReceiveLogs1 Waiting for messages");
            Consumer consumer=new DefaultConsumer(channel){

//                @Override
//                public

            };

        }catch (IOException | TimeoutException e){
            e.printStackTrace();
        }

    }

}
