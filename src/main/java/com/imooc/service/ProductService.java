package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    /* 查询单个商品*/
    ProductInfo findOne(String productId);

    /*** 查询所有商品*/
    List<ProductInfo> findAll();

    /*分页查询所有*/
    Page<ProductInfo> findAll(Pageable pageable);

    /*保存商品信息*/
    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
