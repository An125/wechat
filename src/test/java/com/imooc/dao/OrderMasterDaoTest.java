package com.imooc.dao;

import com.imooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {

    @Autowired
    private OrderMasterDao orderMasterDao;
    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("2");
        orderMaster.setBuyerName("小明");
        orderMaster.setBuyerPhone("13858119874 ");
        orderMaster.setBuyerOpenid("1106022016");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setBuyerAddress("杭州");
        OrderMaster result = orderMasterDao.save(orderMaster);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByBuyerOpenid() {
        Page<OrderMaster> list = orderMasterDao.findByBuyerOpenid("1106022016", new PageRequest(0, 2));
        System.out.println(list.getTotalElements());
    }
}