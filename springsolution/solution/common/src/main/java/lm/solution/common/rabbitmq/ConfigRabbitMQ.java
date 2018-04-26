package lm.solution.common.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;

public class ConfigRabbitMQ {

    public static void configConnectionFactory(ConnectionFactory conFac){

        conFac.setHost(MqConst.HOST);
        conFac.setPort(MqConst.PORT);
        conFac.setUsername(MqConst.USER_NAME);
        conFac.setPassword(MqConst.PASSWORD);

    }

}
