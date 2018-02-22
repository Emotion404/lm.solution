package lm.solution.console;

import lm.solution.jaxws.JaxWsTest;

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
        new JaxWsTest().publishAndClient();
    }

}
