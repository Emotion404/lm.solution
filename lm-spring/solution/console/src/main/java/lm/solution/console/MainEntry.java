package lm.solution.console;

import lm.solution.json.Jackson2xTest;

public class MainEntry {

    public static void main(String[] args) {

        // jackson json test
//        new Jackson2xTest().object2Json();
        new Jackson2xTest().json2Object();
//        new Jackson1xTest().json2Collection();
    }

}
