package lm.solution.pojo.dto;

public class JsonResult {

    private Integer code;
    private String message;

    public static JsonResult fail(int code,String message){

        JsonResult result=new JsonResult();
        result.code=code;
        result.message=message;
        return result;

    }

}
