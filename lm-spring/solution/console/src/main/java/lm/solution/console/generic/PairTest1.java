package lm.solution.console.generic;

import lm.solution.pojo.model.console.generic.Pair;

public class PairTest1 {

//    @Test
    public void genericClassTest(){

        String[] words={"Mary","had","a","little","lamb"};
        Pair<String> mm=new ArrayAlg().minmax(words);
        System.out.println(" min= " +mm.getFirst());
        System.out.println(" max= "+mm.getSecond());

    }

}
