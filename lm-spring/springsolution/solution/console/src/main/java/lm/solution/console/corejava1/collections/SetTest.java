package lm.solution.console.corejava1.collections;

import java.util.*;

public class SetTest {

//    @Test
    public void test(){

        Set<String> words=new HashSet<>();

        Long totalTime=0L;

        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("s");
        list.add("d");
        list.add("f");
        list.add("g");

        Iterator<String> iter=list.iterator();
        while (iter.hasNext()){
            String word =iter.next();
            Long callTime=System.currentTimeMillis();
            words.add(word);
            callTime=System.currentTimeMillis()-callTime;
            totalTime+=callTime;
        }

        Iterator<String> iter2=words.iterator();
        while (iter2.hasNext()){
            System.out.println(iter2.next());
        }
        System.out.println(words.size());
        System.out.println(totalTime);

    }

}
