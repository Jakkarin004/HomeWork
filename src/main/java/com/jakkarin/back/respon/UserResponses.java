package com.jakkarin.back.respon;

import java.util.HashMap;
import java.util.Map;

public class UserResponses {
    private String responseCode;
    private String responseMessage;
    private Object responseData;

    public UserResponses(UserResponData userResponData){
        this.responseData = userResponData;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Object getResponseData() {
        return responseData;
    }

    public void setResponseData(Object responseData) {
        this.responseData = responseData;
    }

}
