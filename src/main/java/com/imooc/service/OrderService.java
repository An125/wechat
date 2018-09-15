package com.imooc.service;

import com.imooc.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *订单服务
 */
public interface OrderService {
    /*创建订单*/
    OrderDTO createOrder(OrderDTO orderDTO);
    /*取消订单*/
    OrderDTO cancel(OrderDTO orderDTO);
    /*支付订单*/
    OrderDTO paid(OrderDTO orderDTO);
    /*完成订单*/
    OrderDTO finish(OrderDTO orderDTO);
    /*查询单个订单*/
    OrderDTO findOne(String orderId);
    /*查询订单列表*/
    Page<OrderDTO> findAll(String buyerOpenId, Pageable pageable);
}
