package lm.solution.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                // 设置 Spring Security 对 "/" "/login" 不拦截
                .antMatchers("/", "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                // 设置 Spring Security 的登录页面访问路径 /login ，登录成功后转向 /chat
                .formLogin().loginPage("/login").defaultSuccessUrl("/chat").permitAll()
                .and()
                .logout().permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                // 在内存中 分配用户并指定角色
                .withUser("wyf").password("wyf").roles("USER")
                .and()
                .withUser("wisely").password("wisely").roles("USER");

    }

    @Override
    public void configure(WebSecurity web) throws Exception {

        // 配置 Spring Security 静态资源不拦截
        web.ignoring()
                .antMatchers("/resources/static/**");

    }

}
