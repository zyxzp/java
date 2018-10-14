package com.example.springboot.enums;

import lombok.Getter;

/**
 * @Auther: Administrator
 * @Date: 2018/10/14 10:32
 * @Description:
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
