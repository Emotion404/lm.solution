package lm.solution.web.config.exceptions;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * spring MVC 统一异常处理
 * */
public class SpringHandlerExceptionResolver implements HandlerExceptionResolver {

    private static Logger logger= LoggerFactory.getLogger(SpringHandlerExceptionResolver.class);

    private FastJsonConfig fastJsonConfig;

    @Autowired
    public SpringHandlerExceptionResolver(FastJsonConfig fastJsonConfig){

        this.fastJsonConfig=fastJsonConfig;

    }

    @Override
    public ModelAndView resolveException(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Object handler,
            Exception ex) {

        return null;

    }

    /**
     * 这个方法是拷贝
     * {@link org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver#doResolveException},
     * 加入自定义处理，实现对400， 404， 405， 406， 415， 500(参数问题导致)， 503的处理
     *
     * @param ex      异常信息
     * @param request 当前请求对象(用于判断当前请求是否为ajax请求)
     * @return 视图模型对象
     * */
    private ModelAndView specialExceptionResolve(Exception ex,HttpServletRequest request){

//        try{
//
//            if(ex instanceof NoHandlerFoundException){
//                return result(HttpExceptionEnum.NOT_FOUND_EXCEPTION, request);
//            }
//
//        }catch (){
//
//        }
        return null;

    }

}
