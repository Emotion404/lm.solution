package lm.solution.webboot;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
@ComponentScan(basePackages = {"lm.solution"})
@MapperScan(basePackages = {"lm.solution.mapper"})
public class Application extends SpringBootServletInitializer {

    // DataSource配置
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){

        return new DataSource();

    }

    // 提供SqlSeesion
    @Bean
    public SqlSessionFactory sqlSessionFactory()
        throws Exception{

        SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
        factoryBean.setDataSource(this.dataSource());
        return factoryBean.getObject();

    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(){

        return new DataSourceTransactionManager(this.dataSource());

    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);

    }

}
