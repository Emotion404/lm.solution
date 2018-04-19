package lm.solution.pojo.model.console.generic;

public class Manager extends Employee {

    private double bonus;
    public double getBonus() {
        return bonus;
    }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Manager(){

        super();

    }

    public Manager(String name,Double bonus,Integer yyyy,Integer mm,Integer dd){

        super(name,yyyy,mm,dd);
        this.bonus=bonus;

    }


}
