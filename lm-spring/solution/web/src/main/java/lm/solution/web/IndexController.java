package lm.solution.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    /**
     * 将处理方法中需要的对象作为参数，即可在处理方法中使用该对象，如下：
     * javax.servlet.ServletRequest
     * javax.servlet.http.HttpServletRequest
     * javax.servlet.ServletResponse
     * javax.servlet.http.HttpServletResponse
     * javax.servlet.http.HttpSession
     * org.springframework.web.context.request.WebRequest
     * org.springframework.web.context.request.NativeWebRequest
     * java.util.Locale
     * java.io.InputStream
     * java.io.Reader
     * java.io.OutputStream
     * java.io.Writer
     * java.security.Principal
     * HttpEntity ?
     * java.util.Map
     * org.springframework.ui.Model
     * org.springframework.ui.ModelMap
     * org.springframework.web.servlet.mvc.support.RedirectAttributes
     * org.springframework.validation.Errors
     * org.springframework.validation.BindingResult
     * org.springframework.web.bind.support.SessionStatus
     * org.springframework.web.util.UriComponentsBuilder
     * @PathVariable
     * @@MatrixVariable
     * @RequestParam
     * @RequestHeader
     * @RequestBody
     * @RequestPart
     * */

    /**
     * 处理方法可返回的类型，如下：
     * org.springframework.web.portlet.ModelAndView
     * org.springframework.ui.Model
     * java.util.Map k,v
     * org.springframework.web.servlet.View
     * java.lang.String
     * HttpEntity
     * ResponseEntity
     * java.util.concurrent.Callable
     * org.springframework.web.context.request.async.DeferredResult
     */

    @RequestMapping("/")
    public String indexPage() {
        return "index";
    }

    @RequestMapping("/excel")
    public String mainPage() {
        return "excel/excel";
    }

    @RequestMapping("/upload")
    public String uploadPage() {
        return "fileupload/upload";
    }

    @RequestMapping("/ImageValidateCodeLogin")
    public String login() {
        return "login/imageValidateCodeLogin";
    }

    @RequestMapping("/restfulapi")
    public String restApi(){
        return "restful/user";
    }

}
