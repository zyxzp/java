package com.example.springboot.utils;

import com.example.springboot.VO.ResultVo;

/**
 * @Auther: Administrator
 * @Date: 2018/10/14 10:40
 * @Description:
 */
public class ResultVOUtil {
    public static ResultVo success(Object object) {
        ResultVo resultVO = new ResultVo();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVo success() {
        return success(null);
    }

    public static ResultVo error(Integer code, String msg) {
        ResultVo resultVO = new ResultVo();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}