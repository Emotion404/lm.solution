package lm.solution.pojo.model.console;

import java.util.List;

public class JsonComplex {

    private String key;
    public String getKey(){
        return this.key;
    }
    public void setKey(String key){
        this.key=key;
    }

    private List<BeginEndBean> anotherKey;
    public List<BeginEndBean> getAnotherKey() {
        return anotherKey;
    }
    public void setAnotherKey(List<BeginEndBean> anotherKey) {
        this.anotherKey = anotherKey;
    }

    private ThirdBean thirdKey;
    public ThirdBean getThirdKey() {
        return thirdKey;
    }
    public void setThirdKey(ThirdBean thirdKey) {
        this.thirdKey = thirdKey;
    }
}
