package lm.solution.common.rabbitmq;

public class MqConst {
    //
    public static final String EXCHANGE_LOG="logs";
    public static final String EXCHANGE_DIRECT_LOG="direct_logs";
    public static final String EXCHANGE_TOPIC_LOG="topic_logs";

    //
    public static final String EXCHANGE_TYPE_TOPIC="topic";

    //
    public static final String QUEUE_TEST="rabbitMQ.test";
    public static final String QUEUE_TASK="task_queue";
    public static final String QUEUE_RPC="rpc_queue";

    //
    public static final String HOST="127.0.0.1";
    public static final Integer PORT=5672;
    public static final String USER_NAME="lm";
    public static final String PASSWORD="2018";
}
