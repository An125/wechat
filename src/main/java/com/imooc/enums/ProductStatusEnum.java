package com.imooc.enums;

import lombok.Data;
import lombok.Getter;

/**
 * 商品状态
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"上架"),
    DOW(1,"下架")
    ;
    private int code;
    private String message;

    ProductStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
