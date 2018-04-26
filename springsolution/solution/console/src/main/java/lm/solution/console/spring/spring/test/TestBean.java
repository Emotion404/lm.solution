package lm.solution.console.spring.spring.test;

public class TestBean {

    public TestBean(String content){
        super();
        this.content=content;
    }

    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
