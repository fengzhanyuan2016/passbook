package com.bmw.passbook.dto;

import com.bmw.passbook.constant.ErrorCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.var;


@Data
@NoArgsConstructor
public class Response {
    private Integer errorCode;
    private String errorMsg;
    private Object data;

    public Response(Object data) {
        this.errorCode = ErrorCode.SUCCESS.getCode();
        this.data = data;
    }

    public static Response SUCCESS(Object data){
        return new Response(data);
    }

    public static Response ERROR(ErrorCode code){
        var response = new Response();
        response.setErrorCode(code.getCode());
        response.setErrorMsg(code.getMsg());
        return response;
    }
}
