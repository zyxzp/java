package com.example.springboot.VO;

import lombok.Data;

/**
 * @Auther: Administrator
 * @Date: 2018/10/13 16:52
 * @Description:
 */
@Data
public class ResultVo<T> {
    private Integer code;
    private String msg;
    private T data;
}
