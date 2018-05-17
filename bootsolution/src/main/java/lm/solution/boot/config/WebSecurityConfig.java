package lm.solution.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
/**
 * WebSecurityConfig 继承 WebSecurityConfigurerAdapter 并注解 @EnableWebSecurity ,
 * 以启用 Spring Security 框架 .
 * */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 重写 void configure(HttpSecurity http) 方法配置 请求授权
     * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // authorizeRequests 方法 做 请求权限配置
        http.authorizeRequests()
                // 设置 Spring Security 对 "/" "/login" 不拦截
                .antMatchers("/", "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()  // 使用 formLogin 定制登录操作
                .loginPage("/login")  // 使用 loginPage 定制登录页面的访问地址 /login
                .defaultSuccessUrl("/")  // 使用 defaultSuccessUrl 指定登录成功后转向的页面 /
                .failureUrl("/login")  // 使用 failureUrl 指定登录失败后转向的页面
                .permitAll()
                .and()
                .rememberMe()  // 使用 rememberMe 开启 cookie 存储用户信息
                .tokenValiditySeconds(3600)  // 使用 tokenValiditySeconds 指定 cookie 有效期 3600 秒
                .key("loginToken") // 使用 key 指定 cookie 中的私钥
                .and()
                .logout()  // 使用 logout 定制注销行为
                .permitAll();  // permitAll 用户可任意访问

    }

    /**
     * 重写 void configure(AuthenticationManagerBuilder auth) 方法配置 用户认证
     * */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /**
         * 这是内存方式，
         * 还可以 数据库方式 等等。
         * */
        auth.inMemoryAuthentication()
                // 在内存中 分配用户并指定角色
                .withUser("wyf").password("wyf").roles("USER")
                .and()
                .withUser("wisely").password("wisely").roles("USER")
                .and()
                .withUser("lm").password("lm").roles("USER");

    }

    /**
     * 重写 void configure(WebSecurity web) 方法配置相关的安全配置
     * */
    @Override
    public void configure(WebSecurity web) throws Exception {

        // 配置 Spring Security 静态资源不拦截
        web.ignoring()
                .antMatchers("/resources/static/**");

    }

}
