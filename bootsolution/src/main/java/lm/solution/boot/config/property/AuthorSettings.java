package lm.solution.boot.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
/**
 * 通过 @ConfigurationProperties 加载 properties 文件内的配置，
 * 通过 prefix 属性指定 properties 的配置前缀
 * 通过 locations 指定 properties 文件的位置 -- 1.5.1 以上版本 废弃不能用了
 * */
//@ConfigurationProperties(prefix = "author", locations = {"classpath:config/author.properties"})
@ConfigurationProperties(prefix = "author")
@PropertySource("classpath:config/author.properties")
public class AuthorSettings {

    private String name;
    private Long age;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public Long getAge() {
        return age;
    }
    public void setAge(Long age) {
        this.age = age;
    }

}
