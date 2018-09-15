package com.imooc.dto;

import lombok.Data;

/**
 * 购物车
 */
@Data
public class CartDTO {
    /*商品的id*/
    private String productId;

    /*商品的数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public CartDTO() {
    }
}
