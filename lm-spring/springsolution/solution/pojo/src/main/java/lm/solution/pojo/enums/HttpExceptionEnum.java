package lm.solution.pojo.enums;

public enum HttpExceptionEnum {

    NOT_FOUND_EXCEPTION(0,"找不到请求对应的处理Handler！"),
    NOT_SUPPORTED_METHOD_EXCEPTION(1,"找不到请求对应的处理Method！"),
    NOT_SUPPORTED_MEDIA_TYPE_EXCEPTION(2,"找不到请求数据支持的MediaType！"),
    NOT_ACCEPTABLE_MEDIA_TYPE_EXCEPTION(3,"无可接收MediaType！"),
    MISSING_REQUEST_PARAMETER_EXCEPTION(4,"丢失请求参数！"),
    REQUEST_BINDING_EXCEPTION(5,"请求模型绑定异常！"),
    NOT_SUPPORTED_CONVERSION_EXCEPTION(6,"找不到请求支持的数据转换！"),
    TYPE_MISMATCH_EXCEPTION(7,"类型未匹配！"),
    MESSAGE_NOT_READABLE_EXCEPTION(8,"消息不能读取！"),
    MESSAGE_NOT_WRITABLE_EXCEPTION(9,"消息不能写出！"),
    NOT_VALID_METHOD_ARGUMENT_EXCEPTION(10,"方法参数无效！"),
    MISSING_REQUEST_PART_EXCEPTION(11,"丢失部门请求！"),
    BIND_EXCEPTION(12,"绑定异常！"),
    ASYNC_REQUEST_TIMEOUT_EXCEPTION(13,"异步请求异常！");

    private HttpExceptionEnum(Integer code,String message){
        this.code=code;
        this.message=message;
    }

    private Integer code;
    public Integer getCode() {
        return code;
    }

    private String message;
    public String getMessage() {
        return message;
    }
}
