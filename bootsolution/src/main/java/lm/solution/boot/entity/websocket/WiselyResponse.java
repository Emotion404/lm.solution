package lm.solution.boot.entity.websocket;

public class WiselyResponse {

    public WiselyResponse(String responseMessage){

        this.responseMessage=responseMessage;

    }

    private String responseMessage;

    public String getResponseMessage() {
        return responseMessage;
    }
}
