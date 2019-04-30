package com.bmw.passbook.constant;

import lombok.Getter;

public enum ErrorCode {
    SUCCESS(0, ""),
    DUPLICATE_NAME(1, "商户名称重复"),
    EMPTY_LOGO(2, ""),
    EMPTY_BUSINESS_LICENSE(3, ""),
    EMPTY_ADDRESS(4, ""),
    MERCHANTS_NOT_EXIST(5, ""),
    ERROR_PHONE(6, "");

    @Getter
    private Integer code;
    @Getter
    private String msg;

    ErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
