package lm.solution.web.config.configs;

import lm.solution.web.config.beans.FastjsonBean;
import lm.solution.web.config.beans.MySqlBean;
import lm.solution.web.config.beans.RedisBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        RedisBean.class,
        MySqlBean.class,
        FastjsonBean.class
})
public class RootConfig {
    /**
     * 此处管理 Beans
     * */
}
