package lm.solution.pojo.model.console.generic;

public class Pair<T> {

    public Pair(){
        first=null;
        second=null;
    }

    public Pair(T first,T second){
        this.first=first;
        this.second=second;
    }

    private T first;

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    private T second;

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

}
