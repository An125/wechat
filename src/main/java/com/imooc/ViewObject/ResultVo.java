package com.imooc.ViewObject;

import lombok.Data;

/**
 * http请求返回的最外层对象
 */
@Data
public class ResultVo<T> {

    /*状态码*/
    private Integer code;
    /*提示信息*/
    private String msg;
    /*返回的信息*/
    private T data;
}
