package lm.solution.console;

import lm.solution.console.rabbitmq.Customer;
import lm.solution.console.rabbitmq.Producer;

public class MainEntry {

    public static void main(String[] args) {

        /**
         * jackson json test
         * */
//        new Jackson2xTest().object2Json();
//        new Jackson2xTest().json2Object();
//        new Jackson1xTest().json2Collection();

        /**
         * jax-ws test
         * */
//        new JaxWsTest().publishAndClient();

        /**
         * rabbitmq
         * */
//        new Producer().publishMsg001();
//        new Customer().consume001();
        /*-------------------------------------*/
        new Producer().pulishTask002();
        new Customer().consumeTask002(false);
        //new Customer().consumeTask002(true);
        /*-------------------------------------*/


    }

}
