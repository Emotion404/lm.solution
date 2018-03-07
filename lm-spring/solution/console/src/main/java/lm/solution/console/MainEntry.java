package lm.solution.console;

import lm.solution.console.json.fastjson.FastjsonTest;

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
//        new Producer().pulishTask002();
//        new Customer().consumeTask002(false);
//        new Customer().consumeTask002(true);
        /*-------------------------------------*/
//        new Customer().consumeFanout003();
//        new Producer().publishFanout003();
        /*-------------------------------------*/
//        new Customer().consumeDirect004();
//        new Customer().consumeDirect004_2();
//        new Producer().publishDirect004();
        /*-------------------------------------*/
//        new Customer().consumeTopic005_1();
//        new Customer().consumeTopic005_2();
//        new Producer().publishTopic005();
        /*-------------------------------------*/

        /**
         * fastjson test
         * */
//        new FastjsonTest().parseListByFastjsonStreamApi();
        new FastjsonTest().parseComplexObject();
    }

}
