package lm.solution.console.corejava1.generic;

import lm.solution.pojo.model.console.generic.Employee;
import lm.solution.pojo.model.console.generic.Manager;
import lm.solution.pojo.model.console.generic.Pair;

public class PairTest3 {

//    @Test
    public void genericCodeTest(){

        Manager ceo=new Manager("Gus Greedy",80D,2003,12,15);
        Manager cfo=new Manager("Sid Sneaky",60D,2003,12,15);
        Pair<Manager> buddies=new Pair<>(ceo,cfo);
        printBuddies(buddies);

        ceo.setBonus(100D);
        cfo.setBonus(90D);
        Manager[] managers={ceo,cfo};

        Pair<Employee> result=new Pair<>();
        minmaxBonus(managers,result);
        printBuddies(result);
        maxminBonus(managers,result);
        printBuddies(result);
    }

    public void printBuddies(Pair<? extends Employee> p){

        Employee first=p.getFirst();
        Employee second=p.getSecond();
        System.out.println(first.getName()+" and "+second.getName()+" ar buddies. ");

    }

    public void minmaxBonus(Manager[] a , Pair<? super Manager> result){

        if(a.length==0){
            return;
        }

        Manager min=a[0];
        Manager max=a[0];

        for(int i=1;i<a.length;i++){
            if(min.getBonus()>a[i].getBonus()){
                min=a[i];
            }
            if(max.getBonus()<a[i].getBonus()){
                max=a[i];
            }
        }

        result.setFirst(min);
        result.setSecond(max);

    }

    public void maxminBonus(Manager[] a,Pair<? super Manager> result){

        this.minmaxBonus(a,result);
        new PairAlg().swapHelper(result);

    }

}
