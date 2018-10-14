package com.example.springboot.enums;

import lombok.Getter;

/**
 * @Auther: Administrator
 * @Date: 2018/10/14 10:32
 * @Description:支付状态
 */
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),

    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
