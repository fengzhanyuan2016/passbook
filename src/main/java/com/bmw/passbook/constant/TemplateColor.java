package com.bmw.passbook.constant;


import lombok.Getter;

public enum TemplateColor {

    RED(1,"红色"),
    GREEN(2,"绿色"),
    BLUE(3,"蓝色");

    @Getter
    private Integer code;
    @Getter
    private String color;
    TemplateColor(Integer code,String color){
        this.code = code;
        this.color = color;
    }






}
