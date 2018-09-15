package com.imooc.controller;

import com.imooc.ViewObject.ProductInfoVo;
import com.imooc.ViewObject.ProductVo;
import com.imooc.ViewObject.ResultVo;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController  {
    @Autowired
    private ProductService productInfoService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("list")
    public ResultVo getList(){

        //1.查询所有上架商品
        List<ProductInfo> list = productInfoService.findAll();
        //2.查询所有类目（一次性查询）
        List<Integer> catList = new ArrayList<>();//这个list里面是没有值的，值从哪里来呢，我们要遍历上面的list
        //传统方法
        for (ProductInfo productInfo:list ) {
            catList.add(productInfo.getCategoryType());

        }
        //精简方法
//        List<Integer> categoroyList  = list.stream()
//                .map(e -> e.getCategoryType())
//                .collect(Collectors.toList());

        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(catList);//这里需要一个list参数
        //3.拼装数据
        List<ProductVo> productVoList = new ArrayList<>();
        for (ProductCategory category:categoryList) {
            //这里先遍历商品类目
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(category.getCategoryName());
            productVo.setCategoryType(category.getCategoryType());
            //遍历商品信息
           List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for (ProductInfo productInfo:list ) {
                //先判断类目是否相等，相等再进行取值
                if (productInfo.getCategoryType().equals(category.getCategoryType())){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    //这里不使用set方法，进行赋值，显得代码太臃肿
                    //使用spring提供的工具类
                    BeanUtils.copyProperties(productInfo,productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList); //这里要等商品信息遍历完之后再取数据

        }



        ResultVo resultVo = new ResultVo();
        resultVo.setData(productVoList);
        return resultVo;
    }
}
