package lm.solution.pojo.enums;

public class ScopeEnum {

    /**
     * 一个 spring 容器中，只有一个 bean 的实例，此为 spring 的默认配置，全容器共享一个实例
     * */
    public static final String SINGLETON = "singleton";

    /**
     * 每次调用，新建一个 bean 的实例
     * */
    public final static String PROTOTYPE ="prototype";

    /**
     * web 项目中，给每一个 http request 新建一个实例
     * */
    public final static String REQUEST ="request";

    /**
     * web 项目中，给每一个 http session 新建一个实例
     * */
    public final static String SESSION="session";

}
