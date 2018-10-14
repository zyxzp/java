package com.example.springboot.exception;

import com.example.springboot.enums.ResultEnum;

/**
 * @Auther: Administrator
 * @Date: 2018/10/14 14:17
 * @Description:
 */
public class SellException extends RuntimeException {


    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
