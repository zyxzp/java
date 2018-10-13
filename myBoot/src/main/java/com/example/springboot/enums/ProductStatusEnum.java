package com.example.springboot.enums;

import lombok.Getter;

/**
 * @Auther: Administrator
 * @Date: 2018/10/13 16:10
 * @Description:
 */
@Getter
public enum ProductStatusEnum {
    UP(0, "在架"), DOWN(1, "下架");
    private Integer code;
    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
