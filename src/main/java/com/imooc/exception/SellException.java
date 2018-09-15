package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * 项目异常类
 */
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
