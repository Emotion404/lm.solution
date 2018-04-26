package lm.solution.console.corejava1.generic;

import lm.solution.pojo.model.console.generic.Pair;

public class PairAlg {

    public boolean hasNulls(Pair<?> p){

        return p.getFirst()==null || p.getSecond()==null;

    }

    public void swap(Pair<?> p){

        swapHelper(p);

    }

    public <T> void swapHelper(Pair<T> p){

        T t=p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);

    }

}
