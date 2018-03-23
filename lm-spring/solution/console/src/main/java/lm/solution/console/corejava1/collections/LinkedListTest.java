package lm.solution.console.corejava1.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {

//    @Test
    public void test01(){

        List<String > a=new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String > b=new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        // b --> a
        ListIterator<String> aIter=a.listIterator();
        Iterator<String> bIter=b.iterator();
        while (bIter.hasNext()){
            if(aIter.hasNext()){
                aIter.next();
            }
            aIter.add(bIter.next());
        }
        System.out.println(a);

        // remove every second --> b
        bIter=b.iterator();
        while (bIter.hasNext()){
            bIter.next();  // 跳过一个元素
            if(bIter.hasNext()){
                bIter.next();
                bIter.remove();  // 删除第二个
            }
        }
        System.out.println(b);

        // bulk remove b --> a
        a.removeAll(b);
        System.out.println(a);

    }

}
