package com.imooc.service.impl;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dataobject.OrderMaster;
import com.imooc.dto.OrderDTO;
import com.imooc.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;

    private String openid = "101102";
    @Test
    public void createOrder() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("2");
        orderDTO.setBuyerAddress("慕课网");
        orderDTO.setBuyerName("anan");
        orderDTO.setBuyerPhone("123465498789");
        orderDTO.setBuyerOpenid(openid);


        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123458");
        orderDetail.setProductQuantity(2);
        orderDetailList.add(orderDetail);

        OrderDTO order = orderService.createOrder(orderDTO);
        System.out.println(order);
    }

    @Test
    public void cancel() {
    }

    @Test
    public void paid() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findAll() {
    }
}