package lm.solution.console.spring.spring.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 通过实现 Condition 接口，并通过重写 matches 方法来构造判断条件
 * */
public class WindowsCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        return context
                .getEnvironment()
                .getProperty("os.name")
                .contains("Windows");

    }

}
