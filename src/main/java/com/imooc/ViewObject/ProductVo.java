package com.imooc.ViewObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 前端返回對象格式
 */
@Data
public class ProductVo {

    @JsonProperty("name") //此注解是为了最后转换成前端需要的name字段
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVoList;
}
