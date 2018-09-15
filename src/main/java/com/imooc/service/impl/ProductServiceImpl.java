package com.imooc.service.impl;
import com.imooc.dao.ProductInfoDao;
import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public ProductInfo findOne(String productId) {
        ProductInfo result = productInfoDao.findOne(productId);
        return result;
    }

    @Override
    public List<ProductInfo> findAll() {
        //只查询商品上架的商品
        List<ProductInfo> list = productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
        return list;
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        Page<ProductInfo> all = productInfoDao.findAll(pageable);
        return all;
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }

    /*加库存*/
    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {
    }
    /*减库存*/
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        //根据productId查询是否存在
        for (CartDTO cartDTO :cartDTOList){
            String productId = cartDTO.getProductId();
            ProductInfo productInfo = productInfoDao.findOne(productId);
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //用从数据库中查出来的库存，减去购物车中的数量
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            //判断一下减完之后的结果，如果小于0表示失败
            if (result < 0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            //不小于0那就设置他的库存
            productInfo.setProductStock(result);
            //最后保存数据
            productInfoDao.save(productInfo);
        }
    }
}
