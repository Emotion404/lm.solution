package lm.solution.web.config.beans;

import com.alibaba.druid.pool.DruidDataSource;
import lm.solution.web.config.configs.properties.DbConfig;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.sql.SQLException;

@Configuration
public class MySqlBean {

    // dataSource 配置数据源
    @Bean(
            name = "dataSource",
            initMethod = "init",
            destroyMethod = "close"
    )
    public DruidDataSource druidDataSource(){

        try {

            //
            DbConfig db=DbConfig.getConfig();

            //
            DruidDataSource dataSource = new DruidDataSource();
            dataSource.setUrl(db.getUrl());
            dataSource.setUsername(db.getUsername());
            dataSource.setPassword(db.getPassword());
            dataSource.setInitialSize(db.getInitialSize());
            dataSource.setMinIdle(db.getMinIdle());
            dataSource.setMaxActive(db.getMaxActive());
            dataSource.setMaxWait(db.getMaxWait());
            dataSource.setTimeBetweenEvictionRunsMillis(db.getTimeBetweenEvictionRunsMillis());
            dataSource.setMinEvictableIdleTimeMillis(db.getMinEvictableIdleTimeMillis());
            dataSource.setValidationQuery(db.getValidationQuery());
            dataSource.setTestWhileIdle(db.getTestWhileIdle());
            dataSource.setTestOnBorrow(db.getTestOnBorrow());
            dataSource.setTestOnReturn(db.getTestOnReturn());
            dataSource.setPoolPreparedStatements(db.getPoolPreparedStatements());
            dataSource.setMaxPoolPreparedStatementPerConnectionSize(db.getMaxPoolPreparedStatementPerConnectionSize());
            dataSource.setFilters(db.getFilters());
            return dataSource;

        }catch (SQLException se){
            se.printStackTrace();
        }

        return null;

    }

    // mybatis和spring完美整合，不需要mybatis的配置映射文件
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactoryBean(DruidDataSource dataSource){

        SqlSessionFactoryBean factory=new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        return factory;

    }

    // DAO接口所在包名，Spring会自动查找其下的类
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){

        MapperScannerConfigurer scannerConfigurer=new MapperScannerConfigurer();
        scannerConfigurer.setBasePackage("lm.solution.mapper");
        scannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return scannerConfigurer;

    }

    // 对dataSource 数据源进行事务管理
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager( DruidDataSource dataSource ){

        DataSourceTransactionManager transactionManager=new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;

    }

}
