package lm.solution.console.spring.scope;

import lm.solution.pojo.enums.ScopeEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ScopeEnum.PROTOTYPE)
public class PrototypeService {
}
