package lm.solution.console.spring.springel;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
@ComponentScan("lm.solution.console.spring.springel")
@PropertySource("classpath:spring/springel/test.properties")
public class ElConfig {

    @Value("I Love You!")  // 注入普通字符串
    private String normal;

    @Value("#{systemProperties['os.name']}")  // 注入操作系统属性
    private String osName;

    @Value("#{T(java.lang.Math).random()*100.0}")  // 注入表达式结果
    private Double randomNumber;

    @Value("#{demoService.another}")  // 注入其它 bean 的属性
    private String fromAnother;

    @Value("classpath:spring/springel/test.txt")  // 注入文件资源
    private Resource testFile;

    @Value("http://www.baidu.com")  // 注入网址资源
    private Resource testUrl;

    /**
     * 注入配置文件需要使用 @PropertySource 指定文件地址，
     * 若使用 @Value 注入，则需要配置一个 PropertySourcesPlaceholderConfigurer 的 bean
     * 注意 @Value("${book.name}") 使用的是 $ 而不是 #
     * 注入 Properties 还可以从 Environment 中获得
     * */
    @Value("${book.name}")  // 注入配置文件 配置
    private String bookName;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure(){

        return new PropertySourcesPlaceholderConfigurer();

    }

    @Autowired
    private Environment environment;

    public void outputResource(){

        try {

            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);

            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));

            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
