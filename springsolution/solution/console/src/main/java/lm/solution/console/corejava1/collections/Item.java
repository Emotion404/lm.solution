package lm.solution.console.corejava1.collections;

import java.util.Objects;

public class Item implements Comparable<Item> {

    private String description;
    private int partNumber;

    public Item(String description,int partNumber){
        this.description=description;
        this.partNumber=partNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "[description="+description+", partNumber="+partNumber+"]";
    }

    public boolean equals(Object other){
        if(this==other){
            return true;
        }
        if(other==null){
            return false;
        }
        if(getClass()!=other.getClass()){
            return false;
        }

        Item otherx=(Item)other;

        return Objects.equals(description,otherx.description) && partNumber==otherx.partNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description,partNumber);
    }

    @Override
    public int compareTo(Item other) {
        int diff=Integer.compare(partNumber,other.partNumber);
        return diff!=0?diff:description.compareTo(other.description);
    }

}
