package com.imooc.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class ProductInfo {
    @Id //这里主键不需要自增，是随机产生的字符
    private String productId;
    /**
     * 名字
     */
    private String productName;
    /**
     * 价格
     */
    private BigDecimal productPrice;
    /**
     *库存
     */
    private Integer productStock;
    /**
     * 描述
     */
    private String productDescription;
    /**
     * 小图
     */
    private String productIcon;
    /**
     * 状态，0正常 ，1下架
     */
    private Integer productStatus;
    /**
     * 类目编号
     */
    private Integer categoryType;
}
